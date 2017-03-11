package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String indexPage(@RequestParam(name = "sort", defaultValue = "", required = false) String sort, ModelMap modelMap) {
        List<Country> allCountries;

        // Sorts the countries by name alphabetically,by population or by default
        switch (sort) {
            case "name":
                allCountries = countryRepository.getByName();
                break;

            case "population":
                allCountries = countryRepository.getByPopulation();
                break;

            default:
                allCountries = countryRepository.getAllCountries();
                break;
        }

        modelMap.put("countries", allCountries);
        return "index";
    }

    @RequestMapping("/country/{name}")
    public String detailPage(@PathVariable String name, ModelMap modelMap) {
        Country country = countryRepository.findByName(name);
        modelMap.put("country", country);
        return "country-details";
    }

}
