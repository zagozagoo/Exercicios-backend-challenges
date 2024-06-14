package com.bosch.example.impl;

import java.util.ArrayList;
import java.util.List;

import com.bosch.example.Services.CityService;
import com.bosch.example.model.City;

public class MockCityService implements CityService {
    private List<City> cities = new ArrayList<>();

    public MockCityService(){

        var city = new City();
        city.setId(1l);
        city.setName("Curitiba");
        city.setState("PR");
        city.setCountry("Brazil");
        cities.add(city);
        
        city = new City();
        city.setId(2l);
        city.setName("Tokyo");
        city.setState("KT");
        city.setCountry("Japan");
        cities.add(city);

        city = new City();
        city.setId(3l);
        city.setName("New York");
        city.setState("NY");
        city.setCountry("United States");
        cities.add(city);

        city = new City();
        city.setId(4l);
        city.setName("Praga");
        city.setState("PR");
        city.setCountry("Chéquia");
        cities.add(city);
    }

    @Override
    public List<City> findByNameContaining (String city) {
        return cities.stream()
        .filter(u -> u.getName().equals(city))
        .toList();
    }

    @Override
    public List<City> findAllCities() {
        return cities;
    }

}
