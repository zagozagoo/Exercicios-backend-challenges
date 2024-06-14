package com.bosch.example.Services;

import com.bosch.example.dto.EnderecoDTO;

public interface CepService {

    public EnderecoDTO consultarCEP(String cep);
}
