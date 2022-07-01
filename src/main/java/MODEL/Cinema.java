/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import padroes.Sala3d;

/**
 *
 * @author lucas
 */
public class Cinema {
    private String endereco, nomeShopping;
    private Sala[] salas = new Sala[10];
    private Sala3d[] salas_3d = new Sala3d[5];

    public Cinema(String endereco, String nomeShopping) {
        this.endereco = endereco;
        this.nomeShopping = nomeShopping;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public String getNomeShopping() {
        return nomeShopping;
    }

    public Sala[] getSalas() {
        return salas;
    }

    public Sala3d[] getSalas_3d() {
        return salas_3d;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNomeShopping(String nomeShopping) {
        this.nomeShopping = nomeShopping;
    }

    public void setSalas(Sala sala) {
       for (int i = 0; i < 10; i++) {
            if (salas[i] == null) {
                salas[i] = sala;
                break;
            }
        }
    }

    public void setSalas_3d(Sala3d sala_3d) {
        for (int i = 0; i < 5; i++) {
            if (salas_3d[i] == null) {
                salas_3d[i] = sala_3d;
                break;
            }
        }
    }
    
    
}
