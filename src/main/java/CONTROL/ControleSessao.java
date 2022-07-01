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
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import MODEL.ArquivoFilme;
import MODEL.ArquivoSala;
import MODEL.ArquivoSessao;
import MODEL.Filme;
import MODEL.Sala;
import MODEL.Sessao;


public class ControleSessao {
    
    public static String tryCadastro(String codFilme, String numSala, String hora){
        if(codFilme.equals("") || numSala.equals("") || hora.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            ArquivoFilme arquivofilme = new ArquivoFilme();
            ArquivoSala arquivosala = new ArquivoSala();
            ArquivoSessao arquivo = new ArquivoSessao();
            
            Filme filme = arquivofilme.buscar(Integer.parseInt(codFilme));
            Sala sala = arquivosala.buscar(Integer.parseInt(numSala));
            Sessao sessao = new Sessao(filme, sala, hora);
            
            Cadastro cadastro = new Cadastro();
            
            return cadastro.cadastrar(sessao);
        }
    }
    
     public static String[] buscar(int codSessao){
        String[] rset;
        rset = new String[12];
        Consulta consulta = new Consulta();
        
        Sessao sessao = consulta.consultarSessao(codSessao);
        
        rset[0] = Integer.toString(sessao.getCodSessao());
        rset[1] = Integer.toString(sessao.getFilme().getCodFilme());
        rset[2] = sessao.getFilme().getTitulo();
        rset[3] = sessao.getFilme().getGenero();
        rset[4] = sessao.getFilme().getDiretor();
        rset[5] = Integer.toString(sessao.getFilme().getAno());
        rset[6] = Integer.toString(sessao.getFilme().getDuracao());
        rset[7] = sessao.getFilme().getClasIndicativa();
        rset[8] = sessao.getFilme().getSinopse();
        rset[9] = Integer.toString(sessao.getSala().getNumSala());
        rset[10] = sessao.getSala().getStatus();
        rset[11] = sessao.getHora();
        
        return rset;
    }
     
     public static boolean isSalaOcupada(int numSala){
        Consulta consulta = new Consulta();
        
        return consulta.isSalaOcupada(numSala);
    }
     
     public static boolean isFilmeEmExibicao(String codFilme){
        Consulta consulta = new Consulta();
        
        return consulta.isFilmeEmExibicao(Integer.parseInt(codFilme));
    } 
     
     public static String alterar(String codSessao, String codFilme, String numSala, String hora){
        if(codSessao.equals("") || codFilme.equals("") || numSala.equals("") || hora.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            ArquivoFilme arquivofilme = new ArquivoFilme();
            ArquivoSala arquivosala = new ArquivoSala();
            ArquivoSessao arquivo = new ArquivoSessao();

            Filme filme = arquivofilme.buscar(Integer.parseInt(codFilme));
            Sala sala = arquivosala.buscar(Integer.parseInt(numSala));
            Sessao sessao = new Sessao(Integer.parseInt(codSessao), filme, sala, hora);
            
            Alteracao alteracao = new Alteracao();
            
            return alteracao.alterar(sessao);
        }
    }
     
      public static String excluir(String codSessao, String codFilme, String numSala, String hora){
        ArquivoFilme arquivofilme = new ArquivoFilme();
        ArquivoSala arquivosala = new ArquivoSala();
        ArquivoSessao arquivo = new ArquivoSessao();

        Filme filme = arquivofilme.buscar(Integer.parseInt(codFilme));
        Sala sala = arquivosala.buscar(Integer.parseInt(numSala));
        Sessao sessao = new Sessao(Integer.parseInt(codSessao), filme, sala, hora); 
        
        Exclusao exclusao = new Exclusao();
        
        return exclusao.excluir(sessao);
    }
      
       public static DefaultTableModel updateTable(){
        ArquivoSessao arquivo = new ArquivoSessao();
        List<Sessao> sessoes = arquivo.getAll();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código Sessão", "Filme", "Sala", "Horário"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for(int i = 0; i < sessoes.size(); i++){
            String cod = Integer.toString(sessoes.get(i).getCodSessao());
            String filme = sessoes.get(i).getFilme().getTitulo();
            String sala = Integer.toString(sessoes.get(i).getSala().getNumSala());
            String horario = sessoes.get(i).getHora();
            
            Object[] linha = {cod, filme, sala, horario};
            
            model.addRow(linha);
        }       
        
        return model;
    }
       
        public static int[] getPoltronas(int codSessao){
        Consulta consulta = new Consulta();
        int[] poltronas;
        
        Sessao sessao = consulta.consultarSessao(codSessao);
        poltronas = new int[50];
        
        System.arraycopy(sessao.getPoltronas(), 0, poltronas, 0, 50);
        
        return poltronas;
    }
        
        public static String venda(String codSessao, String poltrona, String tipo, String valor){
        if(codSessao.equals("") || poltrona.equals("") || tipo.equals("") ||
           valor.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            Consulta consulta = new Consulta();
            Alteracao alteracao = new Alteracao();
            
            Sessao sessao = consulta.consultarSessao(Integer.parseInt(codSessao));
            
            int[] poltronas = new int[50];
            poltronas = sessao.getPoltronas();
            poltronas[Integer.parseInt(poltrona)-1] = 1;
            System.out.println(poltronas[Integer.parseInt(poltrona)-1]);
            sessao.setPoltronas(poltronas);
            
            String ret = alteracao.alterar(sessao);
            
            return "Venda realizada com sucesso!";
        }
    }
}
