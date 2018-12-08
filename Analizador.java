/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alberto.rivero
 */
public class Analizador {
    
    
    public void runAnalizador(){
        
        String patron = ("(for|do|while)|([a-zA-Z]+)|([>|<|==]+)|([0-9]+)|([(|)]+)|([{|}]+)|(=)|(;)");
        String texto = "while(x==5){y=2};";
                Pattern p = Pattern.compile(patron);
                Matcher matcher = p.matcher(texto);
                while(matcher.find()){
                    
                    String token1 = matcher.group(1);
                    if(token1 != null){
                        System.out.println("Palabra reservada: "+token1);
                    }
                    String token2 = matcher.group(2);
                    if(token2 != null){
                        System.out.println("variables: "+token2);
                    }
                    
                     String token3 = matcher.group(3);
                    if(token3 != null){
                        System.out.println("operadores relacionales: "+token3);
                    }
                    String token4 = matcher.group(4);
                    if(token4 != null){
                        System.out.println("valor: "+token4);
                    }
                    
                     String token5 = matcher.group(5);
                    if(token5 != null){
                        System.out.println("signo de agrupacion: "+token5);
                    }
                    String token6 = matcher.group(6);
                    if(token6 != null){
                        System.out.println("llaves: "+token6);
                    }
                    
                     String token7 = matcher.group(7);
                    if(token7 != null){
                        System.out.println("asignacion "+token7);
                    }
                    
                      String token8 = matcher.group(8);
                    if(token8 != null){
                        System.out.println("punto y coma "+token8);
                    }
                    
                    
                     
                    
                   
                  
                    
                    
                    
                    
                }
        
        
        
        
        
    }
    
    
    
}
