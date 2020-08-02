package com.example.NOAA_API;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling {@code Station} transactions.
 * @author adambeard
 *
 */
@RestController
@ResponseBody
@RequestMapping("/api/v1")
public class StationController {
	private static final String INTERNAL_SERVER_ERROR_MESSAGE = "Something went wrong reading from our CSV.";
	private static final String UPROCESSABLE_ENTITY_MESSAGE = "Station contains a malformed date.";
	
	@Autowired
	private StationRepository stationRepository;
	
	/**
	 * Gets a {@code Station} by {@code id}
	 * 
	 * @param stationId the id for the station
	 * @return a ResponseEntity that contains the {@code Station}
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/stations/{id}")
	public ResponseEntity<Object> getStationById(@PathVariable(value="id") String stationId) {
		Station station = null;
		
		try {
			station = stationRepository.findById(stationId);
		} catch(IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(INTERNAL_SERVER_ERROR_MESSAGE);
		} catch(ParseException e) {
			return ResponseEntity.unprocessableEntity().body(UPROCESSABLE_ENTITY_MESSAGE);
		}
		
		if(station == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(station);
	}
}
