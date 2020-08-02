package com.example.NOAA_API;

import java.util.ArrayList;

/**
 * Class representation of a Station.
 * @author adambeard
 *
 */
public class Station {
	private ArrayList<Observation> observations;
	private String stationIdentifier;
	
	/**
	 * Empty constructor for deserialisation
	 */
	public Station() {}
	
	/**
	 * Constructs a {@code Station}.
	 * @param stationIdentifier that identifies the station
	 */
	public Station(String stationIdentifier) {
		this.stationIdentifier = stationIdentifier;
		this.observations = new ArrayList<Observation>();
	}
	
	/**
	 * Adds an {@code Observation} to the {@code Station}.
	 * @param observation recorded at the station.
	 */
	public void addObservation(Observation observation) {
		observations.add(observation);
	}
	
	/**
	 * Gets the identifier for the station.
	 * @return the {@code stationIdentifier}.
	 */
	public String getStationIdentifier() {
		return this.stationIdentifier;
	}
	
	/**
	 * Gets the list of {@code Observations} recorded at the station.
	 * @return an ArrayList of {@code Observations}.
	 */
	public ArrayList<Observation> getObservations() {
		return this.observations;
	}	
}
