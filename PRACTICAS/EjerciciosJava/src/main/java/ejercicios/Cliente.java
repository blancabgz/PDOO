/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.ArrayList;

/**
 *
 * @author Blanca
 */
public class Cliente {
    private String dni;
    private String nombre;
    private ArrayList<Reserva> reservas;
    
    
    public Cliente(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
        this.reservas = new ArrayList<Reserva>();
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void addReserva(Reserva reserva){
        this.reservas.add(reserva);
    }
    
    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }
}
