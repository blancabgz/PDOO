/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionViajes;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Blanca
 */
public class Tren {
    private int numero;
    private String nombre;
    private ArrayList<Parada> paradas;
    private Maquinaria.Convoy convoy;
    private ArrayList<Billete> billetes;

    
    
    public Asiento reservarAsiento(){
        return null;
    }
    
    public void liberarBillete(Billete billete){
       
    }
    
    public void nuevaParada(Estacion estacion, Date horaLlegada, Date horaSalida){
    
    }
}
