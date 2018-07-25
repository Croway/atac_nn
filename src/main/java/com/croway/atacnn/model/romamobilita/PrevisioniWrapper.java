package com.croway.atacnn.model.romamobilita;

public class PrevisioniWrapper {

	private String id_richiesta;
	private Previsioni risposta;

	/**
	 * @return the id_richiesta
	 */
	public String getId_richiesta() {
		return id_richiesta;
	}

	/**
	 * @param id_richiesta
	 *            the id_richiesta to set
	 */
	public void setId_richiesta(String id_richiesta) {
		this.id_richiesta = id_richiesta;
	}

	/**
	 * @return the risposta
	 */
	public Previsioni getRisposta() {
		return risposta;
	}

	/**
	 * @param risposta
	 *            the risposta to set
	 */
	public void setRisposta(Previsioni risposta) {
		this.risposta = risposta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrevisioniWrapper [id_richiesta=" + id_richiesta + ", risposta=" + risposta + "]";
	}

}
