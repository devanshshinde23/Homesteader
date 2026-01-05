package com.example.demo.Model;

import java.util.List;




public class WeatherData {

	public Main main; 
	public List<Weather> weather; 
	public static class Main 
	
	{ 
		public double temp;
		
	} 
	public static class Weather 
	{ 
		public String description;
		
	}
}
