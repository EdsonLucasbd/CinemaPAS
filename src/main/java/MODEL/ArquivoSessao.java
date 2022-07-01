/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Jorge
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArquivoSessao extends Arquivo {
    
    private final String arquivo = "sessoes.csv";
    private final Path arquivoPath = FileSystems.getDefault().getPath(arquivo);
    
    public ArquivoSessao(){
    }
    
    /**
     * Este método é responsável pela geração do arquivo CSV das sessões.
     */
    public void gerar(){
        try {
            FileWriter fwriter = new FileWriter(arquivo);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write("codSessao");
                writer.write(";");
                writer.write("codFilme");
                writer.write(";");
                writer.write("numSala");
                writer.write(";");
                writer.write("hora");
                writer.write(";");
                for(int i = 0; i < 50; i++){
                    writer.write("poltrona"+Integer.toString(i+1));
                    if(i != 49) writer.write(";");
                }
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void inserir(Sessao sessao) throws SessaoDuplicadaException{
        if(!Files.exists(arquivoPath)){
            this.gerar();
        }
        
        //Verificação de duplicidade - a ser implementada
        
        try {
            FileWriter fwriter = new FileWriter(arquivo, true);
            try (BufferedWriter writer = new BufferedWriter(fwriter)) {
                writer.write(Integer.toString(this.incremento(arquivo)));
                writer.write(";");
                writer.write(Integer.toString(sessao.getFilme().getCodFilme()));
                writer.write(";");
                writer.write(Integer.toString(sessao.getSala().getNumSala()));
                writer.write(";");
                writer.write(sessao.getHora());
                writer.write(";");
                for(int i = 0; i < 50; i++){
                    writer.write(Integer.toString(sessao.getPoltronas()[i]));
                    if(i != 49) writer.write(";");
                }
                
                writer.newLine();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public Sessao buscar(int codSessao){
        Sessao sessao = null;
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

                        if(Integer.parseInt(split[0]) == codSessao){  
                            ArquivoFilme arqfilme = new ArquivoFilme();
                            ArquivoSala arqsala = new ArquivoSala();
                            
                            Filme filme = arqfilme.buscar(Integer.parseInt(split[1]));
                            Sala sala = arqsala.buscar(Integer.parseInt(split[2]));
                            
                            int[] poltronas = new int[50];
                            for(int i = 0; i < 50; i++){
                                poltronas[i] = Integer.parseInt(split[i+4]);
                            }
                            
                            sessao = new Sessao(Integer.parseInt(split[0]), filme, sala,
                                                split[3], poltronas);

                            break;
                        }

                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
        
        return sessao;
    }
    
   
    public List<Sessao> getAll(){
        List<Sessao> sessoes = new ArrayList<>();
        Sessao sessao = null;
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
                        ArquivoFilme arqfilme = new ArquivoFilme();
                        ArquivoSala arqsala = new ArquivoSala();
                    
                        Filme filme = arqfilme.buscar(Integer.parseInt(split[1]));
                        Sala sala = arqsala.buscar(Integer.parseInt(split[2]));
                        
                        int[] poltronas = new int[50];
                        for(int i = 0; i < 50; i++){
                            poltronas[i] = Integer.parseInt(split[i+4]);
                        }
                        
                        sessao = new Sessao(Integer.parseInt(split[0]), filme, sala, split[3], poltronas);

                        sessoes.add(sessao);
                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        return sessoes;
    }
    
    
    public List<Sessao> getAllBySala(int numSala){
        List<Sessao> sessoes = new ArrayList<>();
        Sessao sessao = null;
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
                        ArquivoFilme arqfilme = new ArquivoFilme();
                        ArquivoSala arqsala = new ArquivoSala();
                    
                        Filme filme = arqfilme.buscar(Integer.parseInt(split[1]));
                        Sala sala = arqsala.buscar(Integer.parseInt(split[2]));
                        
                        int[] poltronas = new int[50];
                        for(int i = 0; i < 50; i++){
                            poltronas[i] = Integer.parseInt(split[i+4]);
                        }
                        
                        sessao = new Sessao(Integer.parseInt(split[0]), filme, sala, split[3], poltronas);

                        if(sessao.getSala().getNumSala() == numSala)                        
                            sessoes.add(sessao);
                        
                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
        
        return sessoes;
    }
    
   
    public List<Sessao> getAllByFilme(int codFilme){
        List<Sessao> sessoes = new ArrayList<>();
        Sessao sessao = null;
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
                        ArquivoFilme arqfilme = new ArquivoFilme();
                        ArquivoSala arqsala = new ArquivoSala();
                    
                        Filme filme = arqfilme.buscar(Integer.parseInt(split[1]));
                        Sala sala = arqsala.buscar(Integer.parseInt(split[2]));
                        
                        int[] poltronas = new int[50];
                        for(int i = 0; i < 50; i++){
                            poltronas[i] = Integer.parseInt(split[i+4]);
                        }
                        
                        sessao = new Sessao(Integer.parseInt(split[0]), filme, sala, split[3], poltronas);

                        if(filme.getCodFilme() == codFilme)
                            sessoes.add(sessao);
                        
                        rset = reader.readLine();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        return sessoes;
    }
    
    
    public void alterar(Sessao sessao){
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
                    
                    if(Integer.parseInt(split[0]) == sessao.getCodSessao()){                    
                        elemento = Integer.toString(sessao.getCodSessao()).concat(";");
                        elemento += Integer.toString(sessao.getFilme().getCodFilme()).concat(";");
                        elemento += Integer.toString(sessao.getSala().getNumSala()).concat(";");
                        elemento += sessao.getHora().concat(";");
                        for(int i = 0; i < 50; i++){
                            if(i == 49)
                                elemento += Integer.toString(sessao.getPoltronas()[i]);
                            else
                                elemento += Integer.toString(sessao.getPoltronas()[i]).concat(";");
                        }
                        
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
                    Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void excluir(Sessao sessao){
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
                    
                    if(!(Integer.parseInt(split[0]) == sessao.getCodSessao())){
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
                    Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoSessao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}       
