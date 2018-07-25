package com.croway.atacnn.neuralnetwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Brain {
	private static final Logger log = LoggerFactory.getLogger(Brain.class);
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HHmm");

	@SuppressWarnings("rawtypes")
	private NeuralNetwork nn = new MultiLayerPerceptron(2, 2, 1);
	DataSet training = new DataSet(2, 1);
	private static Brain instance;

	public static Brain getInstance() throws FileNotFoundException {
		if (instance == null)
			instance = new Brain();

		return instance;
	}

	private Brain() throws FileNotFoundException {
		log.info("loading brain ...");
		File f = new File("/home/federico/Desktop/atac_nn.nnet");
		if (f.exists()) {
			nn = NeuralNetwork.load(new FileInputStream(f));
			log.info("... brain loaded");
		} else {
			log.info("... nothing to load");
		}

	}
	
	public void addToTraining(Integer minutes, Integer source, Integer palite) {
		log.info("addToTarining minutes " + minutes + " source " + source + " palite " + palite);

		// Normalize data
		double[] inputNorm = normalizeDataInput(palite.doubleValue());
		double[] outputNorm = normalizeDataOutput(minutes.doubleValue());
		
		training.addRow(inputNorm, outputNorm);
	}

	public void learn() {
		log.info("Learning");
		nn.learn(training);
		log.info("Learnt");
	}

	private double[] normalizeDataOutput(double doubleValue) {
		return new double[] { doubleValue / 100 };
	}

	private double[] normalizeDataInput(double doubleValue) {
		return new double[] { (Double.parseDouble(sdf.format(new Date())) / 10000), (doubleValue / 100000) };
	}

	public void predict(Integer palite) {
		log.info("predicting " + palite);

		nn.setInput(normalizeDataInput(palite.doubleValue()));

		nn.calculate();

		double[] minuti = nn.getOutput();

		for (double d : minuti) {
			log.info("predicted " + d);
		}

	}

	public void save() {
		nn.save("/home/federico/Desktop/atac_nn.nnet");
	}

}
