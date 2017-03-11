package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

}
