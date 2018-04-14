
package com.mycompany.ejercicioapigithub;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.eclipse.jgit.api.errors.GitAPIException;


public class Menu {
    
     public void escogerMenu(){
        int op;
        
        do{
        
        op = Integer.parseInt(JOptionPane.showInputDialog("1)Crear repositorio en Github\n"
                                                             + "2)Clonar el proyecto desde Github\n"
                                                             + "3)Inicializar el repositorio\n"
                                                             + "4)Crear un commit\n"
                                                             + "5)Realizar un push\n"
                                                             + "6)Salir"));
        
        switch(op){
            case 1: 
            try {
                Metodos.crearRepositorio();
            } catch (IOException ex) {
                System.out.println("ERRO!"+ex.getMessage());
            }
                break;
                
            case 2: try {
                Metodos.clonar();
            } catch (GitAPIException ex) {
                System.out.println("ERRO!"+ex.getMessage());
            }    
            
                break;
                
            case 3: 
                try {
                Metodos.inicializarRepositorio();
            } catch (GitAPIException ex) {
                System.out.println("ERRO!"+ex.getMessage());
            }
            
                break;
                
            case 4: 
           
                break;
                
            case 5:
                
                break;
                
            case 6: System.exit(0);
                break;
                
            default: JOptionPane.showMessageDialog(null, "La opcion introducida no es válida");
        }
        } while(op!=6);
                                                          
    }
    
}
