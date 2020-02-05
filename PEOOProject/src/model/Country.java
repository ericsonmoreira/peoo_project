package model;

import lesson_07.questions.Question_01;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import util.JSONable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe usada na questão {@link Question_01}
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Country extends JSONable {

    // Come do país.
    private String name;

    // Capital do país
    private String capital;

    // Dimensão do país em km quadrados
    private double dimension;

    // Conjunto de paises vizinhos
    private HashSet<Country> borderCountries = new HashSet<Country>();

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
     * @param borderCountries
     */
    public void setBorderCountries(HashSet<Country> borderCountries) {
        borderCountries.forEach(bc -> this.addBorderCountrie(bc));
    }


    public Country(String name, String capital, double dimension) {
        setName(name);
        setCapital(capital);
        setDimension(dimension);
        setBorderCountries(new HashSet<Country>());
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


    @Override
    @SuppressWarnings("unchecked")
    protected JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        JSONArray borderCountriesJsonArray = new JSONArray();
        /*
         * Obs.: Só funciona assim.
         * Precisa passar como argumento o JSONObject.
         */
        this.borderCountries.forEach(bc -> borderCountriesJsonArray.add(bc.toJSONObject()));

        object.put("name", this.name);
        object.put("capital", this.capital);
        object.put("dimension", this.dimension);
        object.put("borderCountries", borderCountriesJsonArray);

        return object;
    }

}