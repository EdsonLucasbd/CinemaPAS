/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

import java.util.logging.Level;
import java.util.logging.Logger;
import MODEL.ArquivoFilme;
import MODEL.ArquivoFuncionario;
import MODEL.ArquivoGestor;
import MODEL.ArquivoSala;
import MODEL.ArquivoSessao;
import MODEL.CpfException;
import MODEL.Filme;
import MODEL.FilmeDuplicadoException;
import MODEL.Funcionario;
import MODEL.FuncionarioDuplicadoException;
import MODEL.Gestor;
import MODEL.GestorDuplicadoException;
import MODEL.Sala;
import MODEL.SalaDuplicadaException;
import MODEL.Sessao;
import MODEL.SessaoDuplicadaException;

/**
 *
 * @author Jorge
 */
public class Cadastro {
    private static final Logger LOGGER = Logger.getLogger(Cadastro.class.getName());

    public String cadastrar(Filme filme){
        try {
            ArquivoFilme arquivo = new ArquivoFilme();
            arquivo.inserir(filme);
            return "Filme cadastrado com sucesso!";
        } catch (FilmeDuplicadoException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }
    }
    
    public String cadastrar(Funcionario funcionario) throws CpfException{
        if(funcionario.getCpf().length() != 11){
            throw new CpfException();
        }
        
        try{
            ArquivoFuncionario arquivo = new ArquivoFuncionario();
            arquivo.inserir(funcionario);
            return "Funcionário cadastrado com sucesso!";
        }
        catch (FuncionarioDuplicadoException ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }        
    }
    
    public String cadastrar(Gestor gestor) throws CpfException{
        if(gestor.getCpf().length() != 11){
            throw new CpfException();
        }
        
        try{
            ArquivoGestor arquivo = new ArquivoGestor();
            arquivo.inserir(gestor);
            return "Gestor cadastrado com sucesso!";
        }
        catch (GestorDuplicadoException ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }
    }
    
    public String cadastrar(Sala sala){
        try {
            ArquivoSala arquivo = new ArquivoSala();
            arquivo.inserir(sala);
            return "Sala cadastrada com sucesso!";
        } catch (SalaDuplicadaException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }
    }
    
    public String cadastrar(Sessao sessao){
        try {
            ArquivoSessao arquivo = new ArquivoSessao();
            arquivo.inserir(sessao);
            return "Sessão cadastrada com sucesso!";
        } catch (SessaoDuplicadaException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }
    }
}
