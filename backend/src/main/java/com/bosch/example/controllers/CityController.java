package com.bosch.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.Services.CityService;
import com.bosch.example.model.City;

// Exercio 5 - 
@RestController
public class CityController {
    @Autowired
    CityService repo; // CHAMA O DATABSE

    @GetMapping("/cities")
    List<City> getCities() {
        return repo.findAllCities();
    }

    @GetMapping("/cities/{query}")
    List<City> searchCities(@PathVariable String query) {
        return repo.findByNameContaining(query);
    }
}
