package com.croway.atacnn.model.viaggiacon;

public class Percorso {
	
	private String NOMEPERCORSO;
	private String DESTINAZIONE;
	private String LINEA;
	private String LINEAIMG;
	private String BIKE;
	private String DISABILI;
	private String AZ_LINEA;
	private String ID_MTRAM;
	private String NOTE;
	private String TIPOLINEA;
	private String LUNGHEZZA;
	private String FERMATAICONA;

	public String getNOMEPERCORSO() {
		return NOMEPERCORSO;
	}

	public void setNOMEPERCORSO(String NOMEPERCORSO) {
		this.NOMEPERCORSO = NOMEPERCORSO;
	}

	public String getDESTINAZIONE() {
		return DESTINAZIONE;
	}

	public void setDESTINAZIONE(String DESTINAZIONE) {
		this.DESTINAZIONE = DESTINAZIONE;
	}

	public String getLINEA() {
		return LINEA;
	}

	public void setLINEA(String LINEA) {
		this.LINEA = LINEA;
	}

	public String getLINEAIMG() {
		return LINEAIMG;
	}

	public void setLINEAIMG(String LINEAIMG) {
		this.LINEAIMG = LINEAIMG;
	}

	public String getBIKE() {
		return BIKE;
	}

	public void setBIKE(String BIKE) {
		this.BIKE = BIKE;
	}

	public String getDISABILI() {
		return DISABILI;
	}

	public void setDISABILI(String DISABILI) {
		this.DISABILI = DISABILI;
	}

	public String getAZ_LINEA() {
		return AZ_LINEA;
	}

	public void setAZ_LINEA(String AZ_LINEA) {
		this.AZ_LINEA = AZ_LINEA;
	}

	public String getID_MTRAM() {
		return ID_MTRAM;
	}

	public void setID_MTRAM(String ID_MTRAM) {
		this.ID_MTRAM = ID_MTRAM;
	}

	public String getNOTE() {
		return NOTE;
	}

	public void setNOTE(String NOTE) {
		this.NOTE = NOTE;
	}

	public String getTIPOLINEA() {
		return TIPOLINEA;
	}

	public void setTIPOLINEA(String TIPOLINEA) {
		this.TIPOLINEA = TIPOLINEA;
	}

	public String getLUNGHEZZA() {
		return LUNGHEZZA;
	}

	public void setLUNGHEZZA(String LUNGHEZZA) {
		this.LUNGHEZZA = LUNGHEZZA;
	}

	public String getFERMATAICONA() {
		return FERMATAICONA;
	}

	public void setFERMATAICONA(String FERMATAICONA) {
		this.FERMATAICONA = FERMATAICONA;
	}

	@Override
	public String toString() {
		return "ClassPojo [NOMEPERCORSO = " + NOMEPERCORSO + ", DESTINAZIONE = " + DESTINAZIONE + ", LINEA = " + LINEA
				+ ", LINEAIMG = " + LINEAIMG + ", BIKE = " + BIKE + ", DISABILI = " + DISABILI + ", AZ_LINEA = "
				+ AZ_LINEA + ", ID_MTRAM = " + ID_MTRAM + ", NOTE = " + NOTE + ", TIPOLINEA = " + TIPOLINEA
				+ ", LUNGHEZZA = " + LUNGHEZZA + ", FERMATAICONA = " + FERMATAICONA + "]";
	}
}
