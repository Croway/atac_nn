package com.croway.atacnn.model.viaggiacon;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PERCORSILINEA")
public class PercorsiLinea {
	
	private Percorso[] PERCORSO;

	public Percorso[] getPERCORSO() {
		return PERCORSO;
	}

	public void setPERCORSO(Percorso[] PERCORSO) {
		this.PERCORSO = PERCORSO;
	}

	@Override
	public String toString() {
		return "ClassPojo [PERCORSO = " + PERCORSO.toString() + "]";
	}
}