package com.croway.atacnn.model.viaggiacon;

public class MonitoraggioImpianti {
    private String STATO;

    public String getSTATO ()
    {
        return STATO;
    }

    public void setSTATO (String STATO)
    {
        this.STATO = STATO;
    }

	@Override
	public String toString() {
		return "MonitoraggioImpianti [STATO=" + STATO + "]";
	}

}