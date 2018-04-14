
package com.mycompany.ejercicioapigithub;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
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
    public static void clonar() throws GitAPIException {
     
     String repo = JOptionPane.showInputDialog("Indique el repositorio del proyecto");
     String ruta = JOptionPane.showInputDialog("Indique la ruta de la carpeta"); 
     
        Git.cloneRepository()
                .setURI(repo)
                .setDirectory(new File(ruta))
                .call();
    }
    public static void inicializarRepositorio() throws GitAPIException {
        
        String ruta = JOptionPane.showInputDialog("Indique la ruta del proyecto");

        InitCommand init = new InitCommand();
        init.setDirectory(new File(ruta))
                .call();

    }
    public static void crearCommit() throws IOException, GitAPIException {
        
     String ruta = JOptionPane.showInputDialog("Indique la ruta del proyecto");
     String nombre = JOptionPane.showInputDialog("¿Como deseas nombrar el commit?");
       
        FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
        Repository repository = repositoryBuilder.setGitDir(new File(ruta+".git"))
                .readEnvironment()
                .findGitDir()
                .setMustExist(true)
                .build();
        Git git = new Git(repository);      
        AddCommand add = git.add();
        add.addFilepattern(ruta+".git").call();
        CommitCommand commit = git.commit();
        commit.setMessage(nombre).call();
    }
}
