/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Modelo;
import vista.Vista;


public class Controlador {
    
    private Modelo modelo;
    private Vista vista;
    
    public Controlador(Modelo m,Vista v) {
        modelo=m;
        vista=v;
        vista.setControlador(this);
        vista.recibeModelo(m);
    }
    
    public void añadeElementoC1(Integer i) {
        modelo.añadeElementoC1(i);
        vista.recibeModelo(modelo);
    }
    
    public void añadeElementoC2(Integer i) {
        modelo.añadeElementoC2(i);
        vista.recibeModelo(modelo);
    }
    
    
    public void quitaUno() {
        modelo.quitaUno();
        vista.recibeModelo(modelo);
    }
    
 
    
}
