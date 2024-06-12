package com.bosch.example.impl;

public class IMPValidateCpf implements com.bosch.example.Services.ValidateCpfService{

    @Override
    public Boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11)
            return false;
        
        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1*"))
            return false;
        
        // Calcula e compara os dígitos verificadores
        int soma = 0;
        for (int i = 0; i < 9; i++)
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9)
            digito1 = 0;
        
        soma = 0;
        for (int i = 0; i < 10; i++)
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9)
            digito2 = 0;
        
        // Verifica se os dígitos calculados são iguais aos dígitos do CPF
        return digito1 == Character.getNumericValue(cpf.charAt(9)) &&
               digito2 == Character.getNumericValue(cpf.charAt(10));
    }
}
