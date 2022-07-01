/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

/**
 *
 * @author Jorge
 */

import java.util.List;
import javax.swing.table.DefaultTableModel;
import MODEL.ArquivoFilme;
import MODEL.Filme;



public class ControleFilme {
    
    public static String tryCadastro(String titulo, String diretor, String atorPrincipal, String genero, String ano, String duracao, Object clasIndicativa, String sinopse){
        if(titulo.equals("") || diretor.equals("") || genero.equals("") || ano.equals("") || atorPrincipal.equals("") ||
            duracao.equals("") || clasIndicativa == null){
            return "Erro: Complete todas as informações!";
        }else{
            
            Filme filme = new Filme(titulo, genero, sinopse, diretor,atorPrincipal,
                                    Integer.parseInt(ano), clasIndicativa.toString(),
                                    Integer.parseInt(duracao));
                                    
            Cadastro cadastro = new Cadastro();
            
            return cadastro.cadastrar(filme);
        }
    }
    
    public static DefaultTableModel updateTable(){
        ArquivoFilme arquivo = new ArquivoFilme();
        List<Filme> filmes = arquivo.getAll();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código", "Título"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for(int i = 0; i < filmes.size(); i++){
            String cod = Integer.toString(filmes.get(i).getCodFilme());
            String titulo = filmes.get(i).getTitulo();
            
            Object[] linha = {cod, titulo};
            
            model.addRow(linha);
        }       
        
        return model;
    }
    
    public static String[] buscar(int codFilme){
        String[] rset;
        rset = new String[7];
        Consulta consulta = new Consulta();
        
        Filme filme = consulta.consultarFilme(codFilme);
        
        rset[0] = filme.getTitulo();
        rset[1] = filme.getGenero();
        rset[2] = filme.getDiretor();
        rset[3] = filme.getAtorPrincipal();
        rset[4] = Integer.toString(filme.getAno());
        rset[5] = Integer.toString(filme.getDuracao());
        rset[6] = filme.getClasIndicativa();
        rset[7] = filme.getSinopse();
        
        return rset;
    }
    
     public static String alterar(String codFilme, String titulo, String diretor, String atorPrinciapal, String genero, String ano, String duracao, Object clasIndicativa, String sinopse){
        if(codFilme.equals("") || titulo.equals("") || diretor.equals("") || genero.equals("") || ano.equals("") || atorPrinciapal.equals("") ||
           duracao.equals("") || clasIndicativa == null){
            return "Erro: Complete todas as informações!";
        }else{
            Filme filme = new Filme(Integer.parseInt(codFilme), titulo, genero, sinopse, diretor, atorPrinciapal,
                                    Integer.parseInt(ano), clasIndicativa.toString(),
                                    Integer.parseInt(duracao));
            Alteracao alteracao = new Alteracao();
            
            return alteracao.alterar(filme);
        }
    }
     
       public static String excluir(String codFilme, String titulo, String diretor, String atorPrincipal, String genero, String ano, String duracao, Object clasIndicativa, String sinopse){
        Filme filme = new Filme(Integer.parseInt(codFilme), titulo, genero, sinopse, diretor, atorPrincipal,
                                    Integer.parseInt(ano), clasIndicativa.toString(),
                                    Integer.parseInt(duracao));
        Exclusao exclusao = new Exclusao();
        
        return exclusao.excluir(filme);
    }
    
    
}
