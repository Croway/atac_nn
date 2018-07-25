package com.croway.atacnn.model.viaggiacon;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ORARIFERMATA")
public class OrariFermata {
	private String TIME;

	private Fermata[] FERMATA;

	private MonitoraggioImpianti MONITORAGGIOIMPIANTO;

	private String IMPIANTO;

	private String NONMONITORATE;

	public String getTIME() {
		return TIME;
	}

	public void setTIME(String TIME) {
		this.TIME = TIME;
	}

	public Fermata[] getFERMATA() {
		return FERMATA;
	}

	public void setFERMATA(Fermata[] FERMATA) {
		this.FERMATA = FERMATA;
	}

	public MonitoraggioImpianti getMONITORAGGIOIMPIANTO() {
		return MONITORAGGIOIMPIANTO;
	}

	public void setMONITORAGGIOIMPIANTO(MonitoraggioImpianti MONITORAGGIOIMPIANTO) {
		this.MONITORAGGIOIMPIANTO = MONITORAGGIOIMPIANTO;
	}

	public String getIMPIANTO() {
		return IMPIANTO;
	}

	public void setIMPIANTO(String IMPIANTO) {
		this.IMPIANTO = IMPIANTO;
	}

	public String getNONMONITORATE() {
		return NONMONITORATE;
	}

	public void setNONMONITORATE(String NONMONITORATE) {
		this.NONMONITORATE = NONMONITORATE;
	}

	@Override
	public String toString() {
		return "OrariFermata [TIME=" + TIME + ", FERMATA=" + Arrays.toString(FERMATA) + ", MONITORAGGIOIMPIANTO="
				+ MONITORAGGIOIMPIANTO + ", IMPIANTO=" + IMPIANTO + ", NONMONITORATE=" + NONMONITORATE + "]";
	}

}