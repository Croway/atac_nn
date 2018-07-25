package com.croway.atacnn.model.romamobilita;

import java.util.List;

public class PrimoPerPalina {

	private String id_palina;
	private String nome_palina;
	private List<Arrivo> arrivi;

	public String getId_palina() {
		return id_palina;
	}

	public void setId_palina(String id_palina) {
		this.id_palina = id_palina;
	}

	public String getNome_palina() {
		return nome_palina;
	}

	public void setNome_palina(String nome_palina) {
		this.nome_palina = nome_palina;
	}

	public List<Arrivo> getArrivi() {
		return arrivi;
	}

	public void setArrivi(List<Arrivo> arrivi) {
		this.arrivi = arrivi;
	}

	@Override
	public String toString() {
		return "PrimoPerPalina [id_palina=" + id_palina + ", nome_palina=" + nome_palina + ", arrivi=" + arrivi + "]";
	}

}
