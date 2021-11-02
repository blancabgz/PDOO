package ejercicios;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blanca
 */
public class Hotel {
    static private int NUM_HOTELES = 0;
    private final String nombre;
    private final String ciudad;
    private final int estrellas;
    private Director director;
    private final ArrayList<Reserva> reservas;
    private ArrayList<Empleado> empleados;
    private ArrayList<Habitacion> habitaciones;
    
    public Hotel(String nombre, String ciudad, int estrellas){
        NUM_HOTELES++; 
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        reservas = new ArrayList<Reserva>();
        empleados = new ArrayList<Empleado>();
        habitaciones = new ArrayList<Habitacion>();
    }
    
    public static int getNUM_HOTELES(){
        return NUM_HOTELES;
    }
    
    public void setDirector(Director director){
        this.director = director;
    }
    
    public Director getDirector(){
        return this.director;
    }
    
    public void addReserva(Cliente cliente, String fechaEntrada, String fechaSalida){
        Reserva reserva = new Reserva(fechaEntrada, fechaSalida,cliente,this);
        cliente.addReserva(reserva);
        reservas.add(reserva);
    }
    
    public ArrayList<Reserva> getReservas(){
        return this.reservas;
    }

    public boolean addEmpleado(Empleado empleado) {
       empleados.add(empleado);
       return true;
    }
    
    public ArrayList<Empleado> getEmpleados(){
        return this.empleados;
    }
    
    public void addHabitacion(int numero, int cantidad){
        Habitacion habitacion = new Habitacion(numero, cantidad);
        habitaciones.add(habitacion);
    }
    
    public int buscarHabitacionCapacidad(int capacidad){
        int numHabitacion = -1;
        
        for(int i = 0; i < habitaciones.size(); i++){
            if (habitaciones.get(i).getCapacidad() >= capacidad) {
                numHabitacion = i;
                return numHabitacion;
            }
        }
        
        return numHabitacion;
    }
    
    
    
   
}

