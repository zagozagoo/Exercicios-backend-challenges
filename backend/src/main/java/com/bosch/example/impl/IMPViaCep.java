package com.bosch.example.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.client.RestTemplate;

import com.bosch.example.Services.ViaCepService;
import com.bosch.example.utils.Endereco;


public class IMPViaCep implements ViaCepService {
    @Override
    public Endereco consultarCEP(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        RestTemplate restTemplate = new RestTemplate();
        Endereco endereco = restTemplate.getForObject(url, Endereco.class);
        return endereco;
    }
    
}
