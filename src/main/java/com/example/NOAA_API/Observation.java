package com.example.NOAA_API;

import java.util.Date;

/**
 * Class representation of an Observation
 * @author adambeard
 *
 */
public class Observation {
	String mFlag;
	int observationId;
	String qFlag;
	Date recordedDate;
	String sFlag;
	String type;
	int value;
	
	/**
	 * Constructs an {@code Observation}.
	 * @param recordedDate when the observation was observed.
	 * @param type of {@code observation}.
	 * @param value of the recorded {@code observation}
	 * @param mFlag measurement flag for first day of the month.
	 * @param qFlag quality flag for first day of the month.
	 * @param sFlag source flag for the first day of the month.
	 */
	public Observation(int observationId, Date recordedDate, String type, int value, String mFlag, String qFlag, String sFlag) {
		this.observationId = observationId;
		this.recordedDate = recordedDate;
		this.type = type;
		this.value = value;
		this.mFlag = mFlag;
		this.qFlag = qFlag;
		this.sFlag = sFlag;
	}
	
	/**
	 * Gets the {@code id} for the observation.
	 * @return the id of the {@code observation}
	 */
	public int getObservationId() {
		return this.observationId;
	}
	
	/**
	 * Gets the date the {@code observation} was recorded.
	 * @return the Date the {@code observation was recorded}
	 */
	public Date getRecordedDate() {
		return this.recordedDate;
	}
	
	/**
	 * Gets the {@code observation} type.
	 * @return the {@code observation} type/
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Gets the value for the {@code observation}.
	 * @return the {@code observation} value.
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Gets the MFlag for the {@code observation}.
	 * @return the {@code observation} MFlag.
	 */
	public String getMFlag() {
		return this.mFlag;
	}
	
	/**
	 * Gets the QFlag for the {@code observation}.
	 * @return the {@code observation} MFlag.
	 */
	public String getQFlag() {
		return this.qFlag;
	}
	
	/**
	 * Gets the SFlag for the {@code observation}.
	 * @return the {@code observation} MFlag.
	 */
	public String getSFlag() {
		return this.sFlag;
	}
}
