package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.WeatherData;
import com.example.demo.Service.WeatherService;

@Controller 
public class WeatherController {

	@Autowired 
	private WeatherService weatherService; 
	@GetMapping("/weather")
	@ResponseBody 
	public WeatherData getWeather(@RequestParam(defaultValue = "Pune") String city) 
	{
		return weatherService.getWeather(city); 
		}
}
