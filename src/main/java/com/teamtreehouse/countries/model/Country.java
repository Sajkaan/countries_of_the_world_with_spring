package com.teamtreehouse.countries.model;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Country {
    private String name;
    private int population;
    private String capital;
    private List<String> languages;

    public Country(String name, int population, String capital, List<String> languages) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }


    public String getPopulation() {
        String populationString;
        populationString = NumberFormat.getNumberInstance(Locale.GERMAN).format(population);
        return populationString;
    }

    public int getPopulationInt() {
        return population;
    }


    public String getCapital() {
        return capital;
    }

    public List<String> getLanguages() {
        return languages;
    }


}
