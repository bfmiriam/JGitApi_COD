
package com.mycompany.ejercicioapigithub;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;


public class Metodos {
    
     public static void crearRepositorio() throws IOException {
        
        String nombre = JOptionPane.showInputDialog("¿Como deseas nombrar el repositorio?");

        GitHub github = GitHub.connect();
        GHCreateRepositoryBuilder builder;
        builder = github.createRepository(nombre);
        builder.create();
    }
    
}
