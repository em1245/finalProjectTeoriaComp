/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import stack.Stack;

/**
 *
 * @author alberto.rivero
 */
public class Sintactico {

    public boolean validar() {

        Stack pila = new Stack();
        String cadena = "[(5+2)]";

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(' || cadena.charAt(i) == '{' || cadena.charAt(i) == '[') {
                pila.Insertar(cadena.charAt(i));
            } else {
                if (cadena.charAt(i) == ')') {
                    if (pila.Extraer() != '(') {
                        return false;
                    }
                } else {
                    if (cadena.charAt(i) == ']') {
                        if (pila.Extraer() != '[') {
                            return false;
                        }

                    } else {
                        if (cadena.charAt(i) == '}') {
                            if (pila.Extraer() != '{') {
                                return false;
                            }
                        }

                    }
                }
            }
        }
        return pila.stackEmpty();
    }

}
