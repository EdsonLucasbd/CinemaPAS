/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

/**
 *
 * @author Jorge
 */
import MODEL.ArquivoFilme;
import MODEL.ArquivoFuncionario;
import MODEL.ArquivoGestor;
import MODEL.ArquivoSala;
import MODEL.ArquivoSessao;
import MODEL.Filme;
import MODEL.Funcionario;
import MODEL.Gestor;
import MODEL.Sala;
import MODEL.Sessao;


public class Consulta {
    
    public Filme consultarFilme(int codFilme){
        ArquivoFilme arquivo = new ArquivoFilme();
        
        return arquivo.buscar(codFilme);        
    }
    
     public Funcionario consultarFuncionario(String rg){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();
        
        return arquivo.buscar(rg);
    }
    
     public Gestor consultarGestor(String rg){
        ArquivoGestor arquivo = new ArquivoGestor();
        
        return arquivo.buscar(rg);
    }
    
     public Sala consultarSala(int numSala){
        ArquivoSala arquivo = new ArquivoSala();
        
        return arquivo.buscar(numSala);
    }
     
     public Sessao consultarSessao(int codSessao){
        ArquivoSessao arquivo = new ArquivoSessao();
        
        return arquivo.buscar(codSessao);
    }
     
     public boolean isSalaOcupada(int codSala){
        ArquivoSessao arquivo = new ArquivoSessao();
        
        return !arquivo.getAllBySala(codSala).isEmpty();
    }
     
     public boolean isFilmeEmExibicao(int codFilme){
        ArquivoSessao arquivo = new ArquivoSessao();
        
        return !arquivo.getAllByFilme(codFilme).isEmpty();
    }
}
