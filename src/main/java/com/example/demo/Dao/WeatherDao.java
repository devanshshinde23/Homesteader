package com.example.demo.Dao;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.WeatherData;
import com.example.demo.Service.WeatherService;

@Service
public class WeatherDao implements WeatherService{

	
	private final String apiKey = "413303b6fc682efb3c899b63fe406bf5"; // from openweathermap.org 
	private final String baseUrl = "https://api.openweathermap.org/data/2.5/weather"; 
	public WeatherData getWeather(String city) 
	{ 
		String url = baseUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";
	RestTemplate restTemplate = new RestTemplate();
	return restTemplate.getForObject(url, WeatherData.class); 
	}
}
