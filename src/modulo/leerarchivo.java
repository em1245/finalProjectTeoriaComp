/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author julio-cabrera
 */
public class leerarchivo {
    
    
    public void leer (){
        
        javax.swing.JFileChooser j= new javax.swing.JFileChooser();
        j.showOpenDialog(j);
        String path= j.getSelectedFile().getAbsolutePath();

        try {
            FileReader r = new FileReader(path);
            BufferedReader buffer = new BufferedReader (r);
            String temp="";
            while(temp!=null){
            
            temp = buffer.readLine();
            if(temp==null)
                
                break;
                System.out.println(temp);
            
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }
    
    }
    
}
