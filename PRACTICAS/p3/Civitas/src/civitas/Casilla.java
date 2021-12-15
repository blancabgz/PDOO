/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author Blanca
 */
public class Casilla {
    private String nombre;
    private static final int JUGADORES = 4;
    
 
    // Constructor por parámetros
    Casilla (String unNombre){
        this.nombre = unNombre;
    }
    
    
    // Devuelve el nombre de la casilla
    public String getNombre(){
        return nombre;
    }
    
    // Imprime toda la información sobre la casilla
    public String toString() {
        return "Casilla: " + nombre + " ";
    } 
    
    // Informa al diario del jugador que ha caido en la casilla
    
    void informe(int actual, ArrayList<Jugador> todos){
        if(todos.size() <= JUGADORES && todos.size() >= 1){
            Diario.getInstance().ocurreEvento("El jugador " + todos.get(actual) + " ha caido en la casilla " + this.toString());  
        }
    }
    
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
    }
    
}