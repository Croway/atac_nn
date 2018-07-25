package com.croway.atacnn.model.viaggiacon;

public class Fermata {
    private String DESTINAZIONE;

    private String LINEA;

    private String VEICOLO;

    private String IMGMOBY;

    private String MESG;

    private String IMGAC;

    private String IMGDIS;

    private String IMGMEB;

    public String getDESTINAZIONE ()
    {
        return DESTINAZIONE;
    }

    public void setDESTINAZIONE (String DESTINAZIONE)
    {
        this.DESTINAZIONE = DESTINAZIONE;
    }

    public String getLINEA ()
    {
        return LINEA;
    }

    public void setLINEA (String LINEA)
    {
        this.LINEA = LINEA;
    }

    public String getVEICOLO ()
    {
        return VEICOLO;
    }

    public void setVEICOLO (String VEICOLO)
    {
        this.VEICOLO = VEICOLO;
    }

    public String getIMGMOBY ()
    {
        return IMGMOBY;
    }

    public void setIMGMOBY (String IMGMOBY)
    {
        this.IMGMOBY = IMGMOBY;
    }

    public String getMESG ()
    {
        return MESG;
    }

    public void setMESG (String MESG)
    {
        this.MESG = MESG;
    }

    public String getIMGAC ()
    {
        return IMGAC;
    }

    public void setIMGAC (String IMGAC)
    {
        this.IMGAC = IMGAC;
    }

    public String getIMGDIS ()
    {
        return IMGDIS;
    }

    public void setIMGDIS (String IMGDIS)
    {
        this.IMGDIS = IMGDIS;
    }

    public String getIMGMEB ()
    {
        return IMGMEB;
    }

    public void setIMGMEB (String IMGMEB)
    {
        this.IMGMEB = IMGMEB;
    }

	@Override
	public String toString() {
		return "Fermata [DESTINAZIONE=" + DESTINAZIONE + ", LINEA=" + LINEA + ", VEICOLO=" + VEICOLO + ", IMGMOBY="
				+ IMGMOBY + ", MESG=" + MESG + ", IMGAC=" + IMGAC + ", IMGDIS=" + IMGDIS + ", IMGMEB=" + IMGMEB + "]";
	}

}