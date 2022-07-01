/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MEtodos para manipulação do filme, no caso arquivo do filmes
 * @author Jorge
 */
public final class ArquivoFilme extends Arquivo {
    private final String arquivo = "filme.csv";
    private final Path arquivoPath = FileSystems.getDefault().getPath(arquivo);
    
    public ArquivoFilme(){}
    
    private void gerar(){
        try {
            FileWriter fwriter = new FileWriter(arquivo);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write("codFilme");
                writer.write(";");
                writer.write("titulo");
                writer.write(";");
                writer.write("genero");
                writer.write(";");
                writer.write("sinopse");
                writer.write(";");
                writer.write("diretor");
                writer.write(";");
                writer.write("atorPrincipal");
                writer.write(";");
                writer.write("ano");
                writer.write(";");
                writer.write("clasIndicativa");
                writer.write(";");
                writer.write("duracao");
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *  inserção de novos filmes
     *
     */
    public void inserir(Filme filme) throws FilmeDuplicadoException{
        if(!Files.exists(arquivoPath)){
            this.gerar();
        }
        //verificar duplicidade 
        try {
            FileWriter fwriter = new FileWriter(arquivo, true);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write(Integer.toString(this.incremento(arquivo)));
                writer.write(";");
                writer.write(filme.getTitulo());
                writer.write(";");
                writer.write(filme.getGenero());
                writer.write(";");
                writer.write(filme.getSinopse());
                writer.write(";");
                writer.write(filme.getDiretor());
                writer.write(";");
                writer.write(filme.getAtorPrincipal());
                writer.write(";");
                writer.write(Integer.toString(filme.getAno()));
                writer.write(";");
                writer.write(filme.getClasIndicativa());
                writer.write(";");
                writer.write(Integer.toString(filme.getDuracao()));
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Filme buscar(int codFilme){
        
        Filme filme = null;
        FileReader file;
        
        if(Files.exists(arquivoPath)){
            try {
                file = new FileReader(arquivo);
                BufferedReader reader = new BufferedReader(file);

                try {
                    reader.readLine();
                    String rset = reader.readLine();

                    while(rset != null){
                        String[] split = rset.split(";");

                        if(Integer.parseInt(split[0]) == codFilme){                    
                            filme = new Filme(Integer.parseInt(split[0]), split[1], split[2], split[3],
                                        split[4], split[5], Integer.parseInt(split[6]), split [7], Integer.parseInt(split[8]));

                            break;
                        }

                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
        
        return filme;
        
    }
    
        public List<Filme> getAll(){
        List<Filme> filmes = new ArrayList<>();
        Filme filme = null;
        FileReader file;
        
        if(Files.exists(arquivoPath)){
            try {
                file = new FileReader(arquivo);
                BufferedReader reader = new BufferedReader(file);

                try {
                    reader.readLine();
                    String rset = reader.readLine();

                    while(rset != null){
                        String[] split = rset.split(";");

                        filme = new  Filme(Integer.parseInt(split[0]), split[1], split[2], split[3],
                                        split[4], split[5], Integer.parseInt(split[6]), split [7], Integer.parseInt(split[8]));
                        filmes.add(filme);
                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        return filmes;
    }

        public void alterar(Filme filme){
        String completo = "";
        String elemento = "";
        FileReader file;        
        
        try {
            file = new FileReader(arquivo);
            BufferedReader reader = new BufferedReader(file);
            
            try {
                completo = reader.readLine()+"\n";
                String rset = reader.readLine();
                
                while(rset != null){
                    String[] split = rset.split(";");
                    
                    if(Integer.parseInt(split[0]) == filme.getCodFilme()){                    
                        elemento = Integer.toString(filme.getCodFilme()).concat(";");
                        elemento += filme.getTitulo().concat(";");
                        elemento += filme.getGenero().concat(";");
                        elemento += filme.getSinopse().concat(";");
                        elemento += filme.getDiretor().concat(";");
                        elemento += Integer.toString(filme.getAno()).concat(";");
                        elemento += filme.getClasIndicativa().concat(";");
                        elemento += Integer.toString(filme.getDuracao());
                        
                        completo += elemento+"\n";
                    }else{
                        completo += rset+"\n";
                    }
                    
                    rset = reader.readLine();
                }
                
                try {
                    FileWriter fwriter = new FileWriter(arquivo);
                    try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                        String[] all = completo.split("\n");
                        
                        for(int i = 0; i < all.length; i++){
                            writer.write(all[i]);

                            writer.newLine();
                        }

                        writer.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

            public void excluir(Filme filme){
        String completo = "";
        String elemento = "";
        FileReader file;        
        
        try {
            file = new FileReader(arquivo);
            BufferedReader reader = new BufferedReader(file);
            
            try {
                completo = reader.readLine()+"\n";
                String rset = reader.readLine();
                
                while(rset != null){
                    String[] split = rset.split(";");
                    
                    if(!(Integer.parseInt(split[0]) == filme.getCodFilme())){
                        completo += rset+"\n";
                    }
                    
                    rset = reader.readLine();
                }
                
                try {
                    FileWriter fwriter = new FileWriter(arquivo);
                    try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                        String[] all = completo.split("\n");
                        
                        for(int i = 0; i < all.length; i++){
                            writer.write(all[i]);

                            writer.newLine();
                        }

                        writer.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    
}
