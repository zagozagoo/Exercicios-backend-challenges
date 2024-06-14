package com.bosch.example.Services;

import java.util.List;

import com.bosch.example.model.City;

public interface CityService {
    List<City> findByNameContaining(String city);
    List<City> findAllCities();
}
