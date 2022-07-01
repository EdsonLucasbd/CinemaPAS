/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Jorge
 */
public class Sala {

    private int numSala;
    private String status;
    
    public Sala(int numSala, String status){
        this.numSala = numSala;
        this.status = status;
    }
    
    public Sala(){
    }
    
    /**
     * Obter número da sala.
     * @return the numSala
     */
    public int getNumSala() {
        return numSala;
    }

    /**
     * Definir número da sala.
     * @param numSala the numSala to set
     */
    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    /**
     * Obter status de utilização da sala.
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Definir status de utilização da sala.
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }    
}
