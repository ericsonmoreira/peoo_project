package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Country {

	// Nome do país. 
	private String name;
	
	// Capital do país
	private String capital;
	
	// Dimensão do país em km quadrados
	private double dimension;
	
	// Conjunto de paises vizinhos
	private HashSet<Country> borderCountries;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public double getDimension() {
		return dimension;
	}

	public void setDimension(double dimension) {
		this.dimension = dimension;
	}

	public HashSet<Country> getBorderCountries() {
		return borderCountries;
	}

	public void addBorderCountrie(Country country) throws IllegalArgumentException {
		if (this.name.equals(country.name)) {
			throw new IllegalArgumentException("IllegalArgumentException: Conflito entre paises.");
		}
		this.borderCountries.add(country);
	}
	
	/**
	 * 
	 * 
	 * @param borderCountries
	 */
	public void setBorderCountries(HashSet<Country> borderCountries) {
		borderCountries.forEach(bc -> this.addBorderCountrie(bc));
	}
	
	
	public Country(String name, String capital, double dimension) {
		setName(name);
		setCapital(capital);
		setDimension(dimension);		
	}
	
	public boolean equals(Country outro) {
		if (this.name != outro.name || this.capital != outro.capital || this.dimension != outro.dimension) 
			return false;
		if (!(this.borderCountries.containsAll(outro.borderCountries) && outro.borderCountries.containsAll(this.borderCountries))) 
			return false; 
		return true;
	}
	
	/**
	 * @return {@link HashMap} [key -> nome do país] X [value -> capital do país].
	 */
	public HashMap<String, String> getCountryNameForCapital() {
		HashMap<String, String> map = new HashMap<String, String>();
		this.borderCountries.forEach(country -> map.put(country.name, country.capital));
		return map;
	}
	
	
}
