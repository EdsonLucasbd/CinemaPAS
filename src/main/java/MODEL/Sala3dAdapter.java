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
public class Sala3dAdapter extends Sala3d implements ISala {
    
    @Override
    public void descricaoEquipamentos(String equipamentos){
        this.equipamentos = equipamentos;
    }
    
    @Override
    public void qtdOculos3d(int qtdOculos){
        this.qtsOculos = qtdOculos;
    }
}
