package com.bosch.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bosch.example.model.City;

// conectar com o banco
@Repository
public interface JPACityRepository extends JpaRepository<City, Long> {
    List<City> findByNameContaining(String city);
}
