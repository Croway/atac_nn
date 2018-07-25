package com.croway.atacnn.model.romamobilita;

import java.util.List;

public class Previsioni {

	private String nome;
	private Boolean abilitata;
	private Integer id_news;
	private String collocazione;
	private List<Object> veicoli;
	private List<PrimoPerPalina> primi_per_palina;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the abilitata
	 */
	public Boolean getAbilitata() {
		return abilitata;
	}

	/**
	 * @param abilitata
	 *            the abilitata to set
	 */
	public void setAbilitata(Boolean abilitata) {
		this.abilitata = abilitata;
	}

	/**
	 * @return the id_news
	 */
	public Integer getId_news() {
		return id_news;
	}

	/**
	 * @param id_news
	 *            the id_news to set
	 */
	public void setId_news(Integer id_news) {
		this.id_news = id_news;
	}

	/**
	 * @return the collocazione
	 */
	public String getCollocazione() {
		return collocazione;
	}

	/**
	 * @param collocazione
	 *            the collocazione to set
	 */
	public void setCollocazione(String collocazione) {
		this.collocazione = collocazione;
	}

	/**
	 * @return the veicoli
	 */
	public List<Object> getVeicoli() {
		return veicoli;
	}

	/**
	 * @param veicoli
	 *            the veicoli to set
	 */
	public void setVeicoli(List<Object> veicoli) {
		this.veicoli = veicoli;
	}

	/**
	 * @return the primi_per_palina
	 */
	public List<PrimoPerPalina> getPrimi_per_palina() {
		return primi_per_palina;
	}

	/**
	 * @param primi_per_palina
	 *            the primi_per_palina to set
	 */
	public void setPrimi_per_palina(List<PrimoPerPalina> primi_per_palina) {
		this.primi_per_palina = primi_per_palina;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Previsioni [nome=" + nome + ", abilitata=" + abilitata + ", id_news=" + id_news + ", collocazione="
				+ collocazione + ", veicoli=" + veicoli + ", primi_per_palina=" + primi_per_palina + "]";
	}

}
