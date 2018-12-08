/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import vistas.principal_Formulario;

/**
 *
 * @author alberto.rivero
 */


public class Analizador{
ArrayList<String>lexico = new ArrayList<String>();
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    public void runAnalizador(){
        
        //El patron tiene modificado la expresion regular
        //como los codigos no aceptaran decimales, le removi el token o grupo
        //([0-9]+) que permitia combinacionespara valores.
        //le agregue el grupo (0x[0-9a-fA-F]|0X[0-9a-fA-F]+)
        //y un metodo que convierte de hexa a deci.
        
        String patron = ("(for|do|while)|([a-zA-Z]+)|([>|<|==]+)|(0x[0-9a-fA-F]+|0X[0-9a-fA-f]+)|([(|)]+)|([{|}]+)|(=)|(;)");
        
        /*principal_Formulario pr = new principal_Formulario();*/
        String cadena = "";
       
       
                Pattern p = Pattern.compile(patron);
                Matcher matcher = p.matcher(getTexto());
                while(matcher.find()){
                    
                    String token1 = matcher.group(1);
                    if(token1 != null){
                       // System.out.println("Palabra reservada: "+token1);
                        cadena = "-->palabra reservada";
                        lexico.add("\n"+token1+cadena);
                    }
                    String token2 = matcher.group(2);
                    if(token2 != null){
                        //System.out.println("variables: "+token2);
                        cadena = "-->variables";
                        lexico.add("\n"+token2+cadena);
                    }
                    
                     String token3 = matcher.group(3);
                    if(token3 != null){
                       // System.out.println("operadores relacionales: "+token3);
                        cadena = "-->operadores relacioneales";
                        lexico.add("\n"+token3+cadena);
                    }
                    String token4 = matcher.group(4);
                    if(token4 != null){
                       // System.out.println("valor: "+token4);
                       
                       cadena = "-->Hexa-->"+hexa_deci(token4)+"-->Deci";
                       lexico.add("\n"+token4+cadena);
                       
                       
                    }
                    
                     String token5 = matcher.group(5);
                    if(token5 != null){
                        //System.out.println("signo de agrupacion: "+token5);
                        cadena = "-->signo de agrupacion";
                        lexico.add("\n"+token5+cadena);
                    }
                    String token6 = matcher.group(6);
                    if(token6 != null){
                       // System.out.println("llaves: "+token6);
                        cadena = "-->llaves";
                        lexico.add("\n"+token6+cadena);
                    }
                    
                     String token7 = matcher.group(7);
                    if(token7 != null){
                       // System.out.println("asignacion "+token7);
                       cadena = "-->asignacion";
                       lexico.add("\n"+token7+cadena);
                        
                    }
                    
                      String token8 = matcher.group(8);
                    if(token8 != null){
                        //System.out.println("punto y coma "+token8);
                        cadena = "-->punto y coma";
                        lexico.add("\n"+token8+cadena);
                        
                        
                    }
                    
                    

                    
                    
                }
                
             nuevoArchivo(lexico);
        
        
     
        
    }
    
    
    public void nuevoArchivo(ArrayList<String>dato){
        
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        
        try{
            f = new File("analizador.txt");
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);
            for(int i = 0; i < dato.size(); i++){
               
               wr.println(dato.get(i)); 
            }
            
            wr.close();
            bw.close();
           
    
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se puedo generar el nuevo txt");
            
        
    }
    
    }
    
    public long hexa_deci(String n) {
        long suma = 0;
        StringBuilder convertidor = new StringBuilder(n).reverse();
        for (int i = 0; i < convertidor.length() - 2; i++) {
            if (convertidor.charAt(i) == 'a' || convertidor.charAt(i) == 'A') {
                suma += 10 * (Math.pow(16, i));
            } else if (convertidor.charAt(i) == 'b' || convertidor.charAt(i) == 'B') {
                suma += 11 * (Math.pow(16, i));
            } else if (convertidor.charAt(i) == 'c' || convertidor.charAt(i) == 'C') {
                suma += 12 * (Math.pow(16, i));
            } else if (convertidor.charAt(i) == 'd' || convertidor.charAt(i) == 'D') {
                suma += 13 * (Math.pow(16, i));
            } else if (convertidor.charAt(i) == 'e' || convertidor.charAt(i) == 'E') {
                suma += 14 * (Math.pow(16, i));
            } else if (convertidor.charAt(i) == 'f' || convertidor.charAt(i) == 'F') {
                suma += 15 * (Math.pow(16, i));
            } else {
                suma = Integer.parseInt("" + Integer.parseInt(convertidor.charAt(i) + "") * (long) Math.pow(16, i)) + suma;
            }
        }
        
        return suma;
    }
    
    
}
