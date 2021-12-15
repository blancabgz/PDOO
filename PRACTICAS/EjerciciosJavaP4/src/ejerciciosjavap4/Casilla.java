/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosjavap4;

/**
 *
 * @author Blanca
 */
public class Casilla {
    private String nombre;
    Casilla(String nombre){
        this.nombre = nombre;
    }
    
    boolean recibeJugador(){
        System.out.println("Se ha recibido un jugador");
        return true;
    }
}
