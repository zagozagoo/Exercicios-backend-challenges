package com.bosch.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bosch.example.dto.CollatzResult;
import com.bosch.example.dto.ImaginaryResult;
import com.bosch.example.dto.ReverseResult;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestController {
    
    // exercicio 1:
    @GetMapping("reverse/{text}")
    public ReverseResult test(@PathVariable String text) {
        String textInvertido = new StringBuilder(text).reverse().toString();

        if (textInvertido.equals(text)) {
            return new ReverseResult(textInvertido, true);
        }

        return new ReverseResult(textInvertido, false);
    }

    // exercicio 2:
    @GetMapping("/imaexp") 
    public ImaginaryResult testImaginary(@RequestParam Double A, @RequestParam Double b) { //precisa ser o nome que esta no front ?a=dfsfd
        Double Re = A * Math.sin(b);
        Double Im = A * Math.cos(b);

        return new ImaginaryResult(Re, Im);
    }

    // exercicio 3:
    @GetMapping("/collatz")
    public CollatzResult testCollatz(@RequestParam Integer current, @RequestParam Integer step) {
        if (current < 0 || step < 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST
            );
        }

        for(int i = 0 ; i < step ; i++ ) {
            if (current % 2 == 0) {
                current = current / 2;
            } else {
                current = 3 * current + 1;
            }
        }
        return new CollatzResult(current);
    }
    

}