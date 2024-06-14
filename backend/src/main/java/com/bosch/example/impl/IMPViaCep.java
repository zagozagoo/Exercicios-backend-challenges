package com.bosch.example.impl;

import org.springframework.web.client.RestTemplate;

import com.bosch.example.Services.CepService;
import com.bosch.example.dto.EnderecoDTO;

public class IMPViaCep implements CepService {
    @Override
    public EnderecoDTO consultarCEP(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        RestTemplate restTemplate = new RestTemplate();
        EnderecoDTO endereco = restTemplate.getForObject(url, EnderecoDTO.class);
        return endereco;
    }
    
}
