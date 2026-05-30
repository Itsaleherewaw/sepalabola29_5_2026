package com.wintux.computadorita.Tools;

import java.util.Stack;

public class Calculadora {

    public static String convertirAPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c).append(" ");
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    postfix.append(pila.pop()).append(" ");
                }
                if (!pila.isEmpty()) pila.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!pila.isEmpty() && prioridad(pila.peek()) >= prioridad(c)) {
                    postfix.append(pila.pop()).append(" ");
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            postfix.append(pila.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    private static int prioridad(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }

    public static String resolverExpresionPostfix(String postfix) {
        Stack<Integer> pila = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int numero2 = pila.pop(); 
                int numero1 = pila.pop(); 
                int resultadoParcial = 0;

                switch (token) {
                    case "+": resultadoParcial = numero1 + numero2; break;
                    case "-": resultadoParcial = numero1 - numero2; break;
                    case "*": resultadoParcial = numero1 * numero2; break;
                    case "/": resultadoParcial = numero1 / numero2; break;
                }
                pila.push(resultadoParcial);
            } else {
                pila.push(Integer.parseInt(token));
            }
        }

        return String.valueOf(pila.pop());
    }
}