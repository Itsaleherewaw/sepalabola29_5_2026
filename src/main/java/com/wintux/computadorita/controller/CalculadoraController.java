package com.wintux.computadorita.controller;

import com.wintux.computadorita.Tools.Calculadora;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

    @PostMapping("/expresion")
    public String calcularInfix(@RequestBody String infix) {
        String postfix = Calculadora.convertirAPostfix(infix);
        String resultado = Calculadora.resolverExpresionPostfix(postfix);
        return "Postfix: " + postfix + " | Resultado: " + resultado;
    }
}