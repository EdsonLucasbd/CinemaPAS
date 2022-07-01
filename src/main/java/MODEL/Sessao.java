/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Jorge
 */
public class Sessao {

    private int codSessao;
    private Filme filme;
    private Sala sala;
    private String hora;
    private int[] poltronas = new int[50];
    
    public Sessao(int codSessao, Filme filme, Sala sala, String hora, int[] poltronas){
        this.codSessao = codSessao;
        this.filme = filme;
        this.sala = sala;
        this.hora = hora;
        for(int i=0; i < poltronas.length; i++){
            this.poltronas[i] = poltronas[i];
        }
    }
    
    public Sessao(int codSessao, Filme filme, Sala sala, String hora){
        this.codSessao = codSessao;
        this.filme = filme;
        this.sala = sala;
        this.hora = hora;
    }
    
    public Sessao(Filme filme, Sala sala, String hora){
        this.filme = filme;
        this.sala = sala;
        this.hora = hora;
        for(int i=0; i < poltronas.length; i++){
            poltronas[i] = 0;
        }
    }
    
    public Sessao(int codSessao){
        this.codSessao = codSessao;
    }
    
    public Sessao(){
    }
    
    /**
     * Obter o código da sessão.
     * @return 
     */
    public int getCodSessao(){
        return codSessao;
    }
    
    /**
     * Definir o código de uma sessão.
     * @param codSessao 
     */
    public void setCodSessao(int codSessao){
        this.codSessao = codSessao;
    }
    
    /**
     * Obter filme em exibição.
     * @return the filme
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * Definir filme em exibição.
     * @param filme the filme to set
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    /**
     * Obter sala da sessão.
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Definir sala da sessão.
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Obter hora da sessão.
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * Definir hora da sessão.
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Obter poltronas da sessão.
     * @return 
     */
    public int[] getPoltronas(){
        return poltronas;
    }
    
    /**
     * Definir poltronas da sessão.
     * @param poltronas 
     */
    public void setPoltronas(int[] poltronas){
        this.poltronas = poltronas;
    }
    
}

