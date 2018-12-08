/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author alberto.rivero
 */
public class Stack {
    
    private Nodo ultimoValor;
    
    public Stack(){
        ultimoValor = null;
    }
    
    //insertar
    
    public void Insertar(char v){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.informacion = v;
        
        if(ultimoValor == null){
            nuevo_nodo.siguiente = null;
            ultimoValor = nuevo_nodo;
        }
        else{
            nuevo_nodo.siguiente = ultimoValor;
            ultimoValor = nuevo_nodo;
        }
        
    }
  
    
    //extraer
    
    public char Extraer(){
        if(ultimoValor != null){
            char informacion = ultimoValor.informacion;
        ultimoValor = ultimoValor.siguiente;
        return informacion;
        }
        
        else{
            return Character.MAX_VALUE;
            
        }
    }
    
    //saber si esta vacia
    
    
    public boolean stackEmpty(){
        return ultimoValor == null;
    }
    
}
