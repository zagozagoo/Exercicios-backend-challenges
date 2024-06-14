package com.bosch.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.Services.CityService;
import com.bosch.example.model.City;
import com.bosch.example.repositories.JPACityRepository;

public class DatabaseCity implements CityService {
    @Autowired
    JPACityRepository repo;

    @Override
    public List<City> findByNameContaining(String city) {
        return repo.findByNameContaining(city);
    }

    @Override
    public List<City> findAllCities() {
        return repo.findAll();
    }

}
