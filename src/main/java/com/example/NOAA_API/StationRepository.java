package com.example.NOAA_API;
 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;

import org.springframework.stereotype.Repository;

/**
 * A class for reading the data stored in 2017.csv.gz.
 * @author adambeard
 * 
 */
@Repository
public class StationRepository {
	private static final String NOAA_DATA = "src/main/resources/2017.csv.gz";
	
	/**
	 * Constructor for {@Code StationRepository}.
	 */
	public StationRepository() {}
	
	/**
	 * Finds the {@code station} for a given {@code id}.
	 * @param id for the {@code station}.
	 * @return the {@code station} for given {@code id}.
	 * @throws IOException when reading/locating the CSV goes wrong.
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public Station findById(String id) throws IOException, ParseException {
		GZIPInputStream in = new GZIPInputStream(new FileInputStream(NOAA_DATA));
		Reader decoder = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(decoder);
		Station station = null;
		
		String line;
		int count = 0;
		String[] values;
		while((line = br.readLine()) != null) {
			count++;
			values = line.split(",");
			
			if(id.equalsIgnoreCase(values[0]) && station == null) {
				station = new Station(values[0]);
				
				if(values.length >= 7) {
					station.addObservation(new Observation(count, getDate(values[1]), values[2], Integer.parseInt(values[3]),
							values[4], values[5], values[6]));
				}
				
			} else if(id.equalsIgnoreCase(values[0]) && station != null && values.length >= 7) {
				station.addObservation(new Observation(count, getDate(values[1]), values[2], Integer.parseInt(values[3]), values[4],
						values[5], values[6]));
			}
		}
		
		br.close();
		
		return station;
	}
	
	/**
	 * Creates a Date for a date stored as a string.
	 * @param observationDate the date of the {@code Observation} formatted like: yyyyMMdd.
	 * @return the Date for an {@code Observation}.
	 * @throws ParseException when there is an error parsing.
	 */
	private Date getDate(String observationDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.parse(observationDate);
	}
}
