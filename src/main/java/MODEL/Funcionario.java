/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Jorge
 */
public class Funcionario extends Pessoa {

    private String carteiraDeTrabalho;
    private String horaEntrada;
    private String horaSaida;
    
    public Funcionario(String rg, String nome, String cpf, String endereco, String telefone, String dataNasc, String salario, String carteiraDeTrabalho, String horaEntrada, String horaSaida){
        super(nome, rg, cpf, endereco, telefone, dataNasc, salario);
        this.carteiraDeTrabalho = carteiraDeTrabalho;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }
    
    
    public String getCarteiraDeTrabalho() {
        return carteiraDeTrabalho;
    }

    
    public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
        this.carteiraDeTrabalho = carteiraDeTrabalho;
    }

    
    public String getHoraEntrada() {
        return horaEntrada;
    }

    
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    
    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }    
}