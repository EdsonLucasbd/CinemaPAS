/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Jorge
 */
    public class Gestor extends Pessoa {

    private String numContrato;
    
    public Gestor(String rg, String nome, String cpf, String endereco, String telefone, String dataNasc, String salario, String numContrato){
        super(nome, rg, cpf, endereco, telefone, dataNasc, salario);
        this.numContrato = numContrato;
    }
    
    /**
     * Obter número do contrato do gestor.
     * @return the numContrato
     */
    public String getNumContrato() {
        return numContrato;
    }

    /**
     * Definir número do contrato do gestor.
     * @param numContrato the numContrato to set
     */
    public void setNumContrato(String numContrato) {
        this.numContrato = numContrato;
    }
       
}

