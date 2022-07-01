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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import MODEL.ArquivoFuncionario;
import MODEL.ArquivoGestor;
import MODEL.CpfException;
import MODEL.Funcionario;
import MODEL.Gestor;


public class ControlePessoa {
    
    public static String tryCadastroFuncionario(String nome, String rg, String cpf, String endereco, 
                                                String telefone, String dataNasc, String salario, 
                                                String entrada, String saida, String carteira){
        
        if(nome.equals("") || rg.equals("") || cpf.equals("") || endereco.equals("") ||
           telefone.equals("") || dataNasc.equals("") || salario.equals("") || 
           entrada.equals("") || saida.equals("") || carteira.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            Funcionario funcionario = new Funcionario(rg, nome, cpf, endereco, telefone, dataNasc,
                                                      salario, entrada, saida, carteira);
            Cadastro cadastro = new Cadastro();
            
            try {
                return cadastro.cadastrar(funcionario);
            } catch (CpfException ex) {
                Logger.getLogger(ControlePessoa.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            }
        }
    }
    
    public static String tryCadastroGestor(String nome, String rg, String cpf, String endereco, 
                                                String telefone, String dataNasc, String salario, 
                                                String contrato){
        if(nome.equals("") || rg.equals("") || cpf.equals("") || endereco.equals("") ||
           telefone.equals("") || dataNasc.equals("") || salario.equals("") || 
           contrato.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            Gestor gestor = new Gestor(rg, nome, cpf, endereco, telefone, dataNasc,
                                       salario, contrato);
            Cadastro cadastro = new Cadastro();
            
            try {
                return cadastro.cadastrar(gestor);
            } catch (CpfException ex) {
                Logger.getLogger(ControlePessoa.class.getName()).log(Level.SEVERE, null, ex);
                return ex.getMessage();
            }
        }
    }
    
     public static String[] buscarFuncionario(String rg){
        String[] rset;
        rset = new String[10];
        Consulta consulta = new Consulta();
        
        Funcionario funcionario = consulta.consultarFuncionario(rg);
        
        rset[0] = funcionario.getRg();
        rset[1] = funcionario.getNome();
        rset[2] = funcionario.getCpf();
        rset[3] = funcionario.getEndereco();
        rset[4] = funcionario.getTelefone();
        rset[5] = funcionario.getDataNasc();
        rset[6] = funcionario.getSalario();
        rset[7] = funcionario.getCarteiraDeTrabalho();
        rset[8] = funcionario.getHoraEntrada();
        rset[9] = funcionario.getHoraSaida();
        
        return rset;
    }
    
     
     public static String[] buscarGestor(String rg){
        String[] rset;
        rset = new String[8];
        Consulta consulta = new Consulta();
        
        Gestor gestor = consulta.consultarGestor(rg);
        
        rset[0] = gestor.getRg();
        rset[1] = gestor.getNome();
        rset[2] = gestor.getCpf();
        rset[3] = gestor.getEndereco();
        rset[4] = gestor.getTelefone();
        rset[5] = gestor.getDataNasc();
        rset[6] = gestor.getSalario();
        rset[7] = gestor.getNumContrato();
        
        return rset;
    }
     
     
      public static String alterarFuncionario(String rg, String nome, String cpf, String endereco, 
                                 String telefone, String dataNasc, String salario, 
                                 String carteira, String entrada, String saida){
        if(nome.equals("") || rg.equals("") || cpf.equals("") || endereco.equals("") ||
           telefone.equals("") || dataNasc.equals("") || salario.equals("") || 
           entrada.equals("") || saida.equals("") || carteira.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            Funcionario funcionario = new Funcionario(rg, nome, cpf, endereco, telefone,
                                      dataNasc, salario, carteira, entrada, saida);
            Alteracao alteracao = new Alteracao();
            
            return alteracao.alterar(funcionario);
        }
    }
      
      public static String alterarGestor(String rg, String nome, String cpf, String endereco, 
                                 String telefone, String dataNasc, String salario, 
                                 String contrato){
        if(nome.equals("") || rg.equals("") || cpf.equals("") || endereco.equals("") ||
           telefone.equals("") || dataNasc.equals("") || salario.equals("") || 
           contrato.equals("")){
            return "Erro: Complete todas as informações!";
        }else{
            Gestor gestor = new Gestor(rg, nome, cpf, endereco, telefone,
                                      dataNasc, salario, contrato);
            Alteracao alteracao = new Alteracao();
            
            return alteracao.alterar(gestor);
        }
    }
      
      public static DefaultTableModel updateTableFuncionarios(){
        ArquivoFuncionario arquivo = new ArquivoFuncionario();
        List<Funcionario> funcionarios = arquivo.getAll();
        DefaultTableModel model = new DefaultTableModel(new String[]{"RG", "Nome", "CPF"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for(int i = 0; i < funcionarios.size(); i++){
            String rg = funcionarios.get(i).getRg();
            String nome = funcionarios.get(i).getNome();
            String cpf = funcionarios.get(i).getCpf();
            
            Object[] linha = {rg, nome, cpf};
            
            model.addRow(linha);
        }       
        
        return model;
    }
    
      public static DefaultTableModel updateTableGestores(){
        ArquivoGestor arquivo = new ArquivoGestor();
        List<Gestor> gestores = arquivo.getAll();
        DefaultTableModel model = new DefaultTableModel(new String[]{"RG", "Nome", "CPF"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for(int i = 0; i < gestores.size(); i++){
            String rg = gestores.get(i).getRg();
            String nome = gestores.get(i).getNome();
            String cpf = gestores.get(i).getCpf();
            
            Object[] linha = {rg, nome, cpf};
            
            model.addRow(linha);
        }       
        
        return model;
    }
      
      public static String excluirFuncionario(String rg, String nome, String cpf, String endereco, 
                                 String telefone, String dataNasc, String salario, 
                                 String carteira, String entrada, String saida){
        Funcionario funcionario = new Funcionario(rg, nome, cpf, endereco, telefone,
                                      dataNasc, salario, carteira, entrada, saida);
        Exclusao exclusao = new Exclusao();
        
        return exclusao.excluir(funcionario);
    }
      
      
      public static String excluirGestor(String rg, String nome, String cpf, String endereco, 
                                 String telefone, String dataNasc, String salario, String contrato){
        Gestor gestor = new Gestor(rg, nome, cpf, endereco, telefone,
                                      dataNasc, salario, contrato);
        Exclusao exclusao = new Exclusao();
        
        return exclusao.excluir(gestor);
    }
}
