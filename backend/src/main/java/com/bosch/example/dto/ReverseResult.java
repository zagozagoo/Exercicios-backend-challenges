package com.bosch.example.dto;

    // exercicio 1:


/*
 * Classe imutável (não tem set), que será usada pelo Spring
 * para gerar um arquivo .json com a mesma estrutura do record.
 * {
 *    "result" : valor,
 *    "palindrome" : valor
 * }
 */
public record ReverseResult(String result, Boolean palindrome) { }
