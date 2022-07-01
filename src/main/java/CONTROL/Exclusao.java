/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

import MODEL.Filme;
import MODEL.Sessao;
import MODEL.ArquivoFilme;
import MODEL.ArquivoFuncionario;
import MODEL.ArquivoGestor;
import MODEL.ArquivoSala;
import MODEL.ArquivoSessao;
import MODEL.Funcionario;
import MODEL.Gestor;
import MODEL.Sala;


/**
 *
 * @author Jorge
 */
public class Exclusao {
   public String excluir(Filme filme){
        ArquivoFilme arquivo = new ArquivoFilme();        
        arquivo.excluir(filme);
        return "Filme excluído com sucesso!";
    }
   
     public String excluir(Funcionario funcionario){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();        
        arquivo.excluir(funcionario);
        return "Funcionário excluído com sucesso!";
    }
     
       public String excluir(Gestor gestor){
        ArquivoGestor arquivo = new ArquivoGestor();        
        arquivo.excluir(gestor);
        return "Gestor excluído com sucesso!";
    }
       
       public String excluir(Sala sala){
        ArquivoSala arquivo = new ArquivoSala();        
        arquivo.excluir(sala);
        return "Sala excluída com sucesso!";
    }
     public String excluir(Sessao sessao){
        ArquivoSessao arquivo = new ArquivoSessao();        
        arquivo.excluir(sessao);        
        return "Sessão excluída com sucesso!";
    }
    
}
