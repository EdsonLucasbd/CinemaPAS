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
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import MODEL.Sala;
import MODEL.ArquivoSala;


public class ControleSala {
    
      public static int getProximoCodigo(){
        return ArquivoSala.incremento(ArquivoSala.arquivo);
    }
      
      public static String tryCadastro(String numero, Object status){
        if(numero.equals("") || status==null){
            return "Erro: Complete todas as informações!";
        }else{
            Sala sala = new Sala(Integer.parseInt(numero), status.toString());
            Cadastro cadastro = new Cadastro();
            
            return cadastro.cadastrar(sala);
        }
    }
      
      
       public static DefaultListModel updateList(){
        DefaultListModel<String> model = new DefaultListModel<>();
        ArquivoSala arquivo = new ArquivoSala();
        List<Sala> salas = arquivo.getAll();
        
        model.removeAllElements();
        
        for(int i = 0; i < salas.size(); i++){
            if(salas.get(i).getStatus().equals("Em condição de uso"))
                model.addElement(Integer.toString(salas.get(i).getNumSala()));
        }
        
        return model;
    }
       
        public static DefaultTableModel updateTable(){
        ArquivoSala arquivo = new ArquivoSala();
        List<Sala> salas = arquivo.getAll();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Número", "Status"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for(int i = 0; i < salas.size(); i++){
            String num = Integer.toString(salas.get(i).getNumSala());
            String status = salas.get(i).getStatus();
            
            Object[] linha = {num, status};
            
            model.addRow(linha);
        }       
        
        return model;
    }
        
        public static String[] buscar(int numSala){
        String[] rset;
        rset = new String[1];
        Consulta consulta = new Consulta();
        
        Sala sala = consulta.consultarSala(numSala);
        
        rset[0] = sala.getStatus();
        
        return rset;
    }
        
         public static String alterar(String numSala, Object status){
        if(numSala.equals("") || status == null){
            return "Erro: Complete todas as informações!";
        }else{
            Sala sala = new Sala(Integer.parseInt(numSala), status.toString());
            Alteracao alteracao = new Alteracao();
            
            return alteracao.alterar(sala);
        }
    }
         
         public static String excluirSala(String numSala, Object status){
        Sala sala = new Sala(Integer.parseInt(numSala), status.toString());
        Exclusao exclusao = new Exclusao();
        
        return exclusao.excluir(sala);
        }
}
