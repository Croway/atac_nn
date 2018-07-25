package com.croway.atacnn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NNModel")
public class NNModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "time")
	private double time;
	@Column(name = "palite")
	private double palite;
	@Column(name = "minutes")
	private double minutes;
	
	public NNModel() {
		time = 1;
		palite = 2;
		minutes = 3;
	}

	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * @return the palite
	 */
	public double getPalite() {
		return palite;
	}

	/**
	 * @param palite
	 *            the palite to set
	 */
	public void setPalite(double palite) {
		this.palite = palite;
	}

	/**
	 * @return the minutes
	 */
	public double getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes
	 *            the minutes to set
	 */
	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

}
