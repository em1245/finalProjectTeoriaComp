/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import javax.swing.JOptionPane;
import modulo.Analizador;
import modulo.Sintactico;
import vistas.principal_Formulario;

/**
 *
 * @author alberto.rivero
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        principal_Formulario pf = new principal_Formulario(); 
        pf.show();
        Analizador run = new Analizador();
        
        Sintactico s = new Sintactico();
        run.runAnalizador();
        
        boolean opc = s.validar();
        if(opc == true){
            JOptionPane.showMessageDialog(null, "es correcto");
        }
        else{
            JOptionPane.showMessageDialog(null, "Es incorrecto");
        }
        
    }
    
}
