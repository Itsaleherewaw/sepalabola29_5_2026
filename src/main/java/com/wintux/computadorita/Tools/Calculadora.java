package com.wintux.computadorita.Tools;

import java.util.Stack;

public class Calculadora {

    // Este es el método exacto que mostró el profe en la videollamada
    public static String resolverExpresionPostfix(String postfix) {
        Stack<Integer> pila = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            // Si es un operador, sacamos dos números y operamos
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int numero2 = pila.pop(); 
                int numero1 = pila.pop(); 
                int resultadoParcial = 0;

                switch (token) {
                    case "+":
                        resultadoParcial = numero1 + numero2;
                        break;
                    case "-":
                        resultadoParcial = numero1 - numero2;
                        break;
                    case "*":
                        resultadoParcial = numero1 * numero2;
                        break;
                    case "/":
                        resultadoParcial = numero1 / numero2;
                        break;
                }
                pila.push(resultadoParcial);
            } 
            // Si es un número, directo a la pila
            else {
                pila.push(Integer.parseInt(token));
            }
        }

        return String.valueOf(pila.pop());
    }
}