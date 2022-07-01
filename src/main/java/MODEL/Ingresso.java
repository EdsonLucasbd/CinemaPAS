/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Jorge
 */
public class Ingresso {

    private String tipo;
    private double valor;
    private Sessao sessao;
    
    public Ingresso(String tipo, double valor, Sessao sessao){
        this.tipo = tipo;
        this.valor = valor;
        this.sessao = sessao;
    }
    
    
    public String getTipo() {
        return tipo;
    }

    /**
     * Definir tipo do ingresso.
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obter valor do ingresso.
     * @return valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * Definir valor do ingresso.
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Obter sessão correspondente ao ingresso.
     * @return sessao
     */
    public Sessao getSessao() {
        return sessao;
    }

    /**
     * Definir sessão que deverá corresponder ao ingresso.
     * @param sessao
     */
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }   
    
}

