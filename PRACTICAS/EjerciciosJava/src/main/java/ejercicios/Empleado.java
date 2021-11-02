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
public class Empleado {
    private String nombre;
    private ArrayList<Hotel> trabajos;
    
    public Empleado(String nombre){
        this.nombre = nombre;
        trabajos = new ArrayList<>();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public boolean addTrabajo(Hotel hotel){
        if(trabajos.size() < 3){
            trabajos.add(hotel);
            hotel.addEmpleado(this);
            return true;
        }
        return false;
    }
}
