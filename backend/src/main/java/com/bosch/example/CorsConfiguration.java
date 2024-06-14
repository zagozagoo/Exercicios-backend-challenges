package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bosch.example.Services.CityService;
import com.bosch.example.Services.UserCreateService;
import com.bosch.example.Services.CepService;
import com.bosch.example.impl.DatabaseCity;
import com.bosch.example.impl.IMPUser;
import com.bosch.example.impl.IMPViaCep;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:5257")
            .allowedMethods(
                "GET", "POST", "PUT", "PATCH", "DELETE"
            );
    }


    @Bean //quando é chamado um cpf ele entrega essa instancia
    @Scope("singleton")
    public CityService cityService() {
        return new DatabaseCity(); // Escolha entre Mock ou Banco
    }

    @Bean
    public CepService viaCepService() {
        return new IMPViaCep();
    }

    @Bean
    public UserCreateService UserService() {
        return new IMPUser();
    }
}
