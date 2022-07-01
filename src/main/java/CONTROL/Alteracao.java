/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

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
/**
 *
 * @author Jorge
 */
public class Alteracao {
    
     public String alterar(Filme filme){
        ArquivoFilme arquivo = new ArquivoFilme();
        arquivo.alterar(filme);
        return "Filme alterado com sucesso!";
    }
     
     public String alterar(Funcionario funcionario){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();        
        arquivo.alterar(funcionario);
        return "Funcionário alterado com sucesso!";
    }
     
    public String alterar(Gestor gestor){
        ArquivoGestor arquivo = new ArquivoGestor();        
        arquivo.alterar(gestor);
        return "Gestor alterado com sucesso!";
    }
    
    public String alterar(Sala sala){
        ArquivoSala arquivo = new ArquivoSala();
        arquivo.alterar(sala);
        return "Sala alterada com sucesso!";
    }
    
    public String alterar(Sessao sessao){
        ArquivoSessao arquivo = new ArquivoSessao();
        arquivo.alterar(sessao);
        return "Sessão alterada com sucesso!";
    }
}
