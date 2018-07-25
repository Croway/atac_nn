package com.croway.atacnn.business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.croway.atacnn.model.romamobilita.Arrivo;
import com.croway.atacnn.model.romamobilita.PrevisioniWrapper;
import com.croway.atacnn.model.romamobilita.PrimoPerPalina;
import com.croway.atacnn.model.viaggiacon.Fermata;
import com.croway.atacnn.model.viaggiacon.OrariFermata;
import com.croway.atacnn.neuralnetwork.Brain;
import com.croway.atacnn.util.ApiEndpoint;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AtacNN {
	private static final Logger log = LoggerFactory.getLogger(AtacNN.class);
	
	private static final int palite = 70329;
	private static final String bus = "412";
	
	private JAXBContext orariFermataJAXBContext;
	private Unmarshaller orariFermataUnmarshaller;
	private RestTemplate restTemplate = new RestTemplate();
	private final String orariFermataURL = ApiEndpoint.Viaggiacon.base + "/" + ApiEndpoint.Viaggiacon.orariFermata;
	private String devKey = "QkC4GiNZjNRveZd_JXfsGMzRFwbvh68c";
	private String token = null;
	private ObjectMapper mapper = new ObjectMapper();
	private Brain brain;
	
	public AtacNN() throws JAXBException, FileNotFoundException {
		log.info("AtacNN startup");

		this.orariFermataJAXBContext = JAXBContext.newInstance(OrariFermata.class);
		this.orariFermataUnmarshaller = orariFermataJAXBContext.createUnmarshaller();

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		brain = Brain.getInstance();
	}

	@PostConstruct
	public void getToken() throws MalformedURLException, XmlRpcException {
		Object[] params = new Object[] { devKey, "atacNN" };

		log.info("getting token ...");

		token = (String) clientRpc(ApiEndpoint.Muoviroma.autenticazione).execute("autenticazione.Accedi", params);

		log.info("token " + token);
	}

	private XmlRpcClient clientRpc(String url) throws MalformedURLException {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL(url));
		XmlRpcClient client = new XmlRpcClient();
		client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
		client.setConfig(config);
		return client;
	}
	
	@Scheduled(fixedDelay = 60000, initialDelay = 60000)
	public void learn() {
		brain.learn();
	}

	@Scheduled(fixedDelay = 10000)
	public void predict() {
		log.info("predict");
		brain.predict(palite);
	}

	@Scheduled(fixedDelay = 60000)
	public void scheduledLogic() throws JAXBException, IOException, XmlRpcException {
		log.info("scheduledLogic");

		if (token != null) {
			// string token: identificativo per gli utenti autorizzati
			// int id_palina: numero della palina richiesta
			// string lingua: codice della lingua, utilizzato per dare informazioni sulle
			// disabilitazioni se e solo se disponibili nella lingua richiesta
			Object[] params = new Object[] { token, palite, "it" };
			@SuppressWarnings("unchecked")
			HashMap<String, Object> previsioniMap = (HashMap<String, Object>) clientRpc(ApiEndpoint.Muoviroma.paline)
					.execute("paline.Previsioni", params);

			PrevisioniWrapper previsioni = mapper.convertValue(previsioniMap, PrevisioniWrapper.class);

			boolean busFound = false;
			for (PrimoPerPalina primoPerPalina : previsioni.getRisposta().getPrimi_per_palina()) {
				for (Arrivo arrivo : primoPerPalina.getArrivi()) {
					Integer minuti = null;
					if (arrivo.getLinea().equals(bus)) {
						busFound = true;
						if (arrivo.getTempo_attesa() != null)
							minuti = arrivo.getTempo_attesa();
					}

					if (minuti != null) {
						brain.addToTraining(minuti, 0, palite);

						minuti = null;
					}
				}
			}
			if (!busFound) {
				brain.addToTraining(99, 0, palite);
			}

			ResponseEntity<Resource> responseEntity = restTemplate.exchange(orariFermataURL + "?impianto=" + palite,
					HttpMethod.GET, null, Resource.class);

			OrariFermata orariFermata = (OrariFermata) this.orariFermataUnmarshaller
					.unmarshal(responseEntity.getBody().getInputStream());

			busFound = false;
			for (Fermata fermata : orariFermata.getFERMATA()) {
				if (bus.equals(fermata.getLINEA().trim())) {
					busFound = true;
					// recupera minuti
					Integer minuti = null;
					if ("In Arrivo".equals(fermata.getMESG().trim())) {
						minuti = 0;
					} else if (fermata.getMESG() != null) {
						if (fermata.getMESG().indexOf("(") > -1 && fermata.getMESG().indexOf("'") > -1) {
							minuti = Integer.parseInt(fermata.getMESG().substring(fermata.getMESG().indexOf("(") + 1,
									fermata.getMESG().indexOf("'")));
						}
					} else {
						minuti = 99;
					}
					if (minuti != null) {
						brain.addToTraining(minuti, 1, palite);

						minuti = null;
					}
					break;
				}
			}
			if (!busFound) {
				brain.addToTraining(99, 1, palite);
			}
		}
	}

	@PreDestroy
	public void destroy() {
		log.info("saving brain ...");
		brain.save();
		log.info("... brain saved");
	}
}
