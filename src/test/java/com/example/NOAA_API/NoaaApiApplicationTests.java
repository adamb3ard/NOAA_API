package com.example.NOAA_API;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NoaaApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NoaaApiApplicationTests {
	private static final String STATIONS_READ = "/stations/afm00040948";
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetStationById() {
		Station station = restTemplate.getForObject(getRootUrl() + STATIONS_READ, Station.class);
		Assert.assertNotNull(station);
	}

}
