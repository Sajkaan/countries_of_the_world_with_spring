package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryRepository {

    private static List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("India", 1342512706, "New Delhi", Arrays.asList("Hindi", "English")),
            new Country("Ecuador", 16144000, "Quito", Arrays.asList("Spanish")),
            new Country("France", 66991000, "Paris", Arrays.asList("French")),
            new Country("Italy", 60674003, "Rome", Arrays.asList("Italian")),
            new Country("Kenya", 46661552, "Nairobi", Arrays.asList("English", "Kiswahili"))
    );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country findByName(String name) {
        for (Country country : ALL_COUNTRIES) {
            if (country.getName().equals(name)) {
                return country;
            }
        }
        return null;
    }

    public List<Country> getByName() {
        return ALL_COUNTRIES.stream()
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
                .collect(Collectors.toList());
    }

    public List<Country> getByPopulation() {
        return ALL_COUNTRIES.stream()
                .sorted((c1, c2) -> c2.getPopulationInt() - (c1.getPopulationInt()))
                .collect(Collectors.toList());
    }

}
