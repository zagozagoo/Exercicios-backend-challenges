package com.bosch.example.Services;

import com.bosch.example.utils.Endereco;

public interface ViaCepService {

    public Endereco consultarCEP(String cep);
}
