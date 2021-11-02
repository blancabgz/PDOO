/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejercicios.Hotel;
import ejercicios.Director;
import ejercicios.Reserva;
import ejercicios.Cliente;
import ejercicios.Empleado;
import java.util.ArrayList;

/**
 *
 * @author Blanca
 */
public class mainHoteles {
    public static void main(String[] args) {
        ArrayList<Reserva> reservasHotel;
        ArrayList<Reserva> reservasCliente;
        Reserva reserva;
        
        // creo hoteles
        Hotel hotel = new Hotel("Sierra Nevada", "Ciudad",2);
        Hotel hotel2 = new Hotel("Granada", "CiudadA",3);
        Hotel hotel3 = new Hotel("Presidente", "CiudadAb",1);
        
        // creo el director
        Director director = new Director("Pedro", 759368284);
        
        // establezco el director
        hotel.setDirector(director);
        
        // creo clientes 
        Cliente cliente = new Cliente("75936828","Blanca");
        Cliente cliente2 = new Cliente("75936829","Lucia");

       
        System.out.println("El numero de hoteles es: " + Hotel.getNUM_HOTELES());
        System.out.println("El director del hotel es: " + hotel.getDirector().getNombre());
        
        // añado reservas al hotel de diferentes clientes
        hotel2.addReserva(cliente, "25/07/2021", "27/07/2021");
        hotel2.addReserva(cliente2, "28/07/2021", "29/07/2021");
        hotel2.addReserva(cliente, "25/08/2021", "27/08/2021");
        hotel2.addReserva(cliente2, "28/08/2021", "29/08/2021");
        
        // guardo las reservas del hotel 2
        reservasHotel = hotel2.getReservas();
        
        // imprimo las reservas
        for(int i = 0; i < reservasHotel.size();  i++){
            System.out.print(reservasHotel.get(i).toStringHotel());
        }
        
        // guardo las reservas del cliente
        reservasCliente = cliente.getReservas();
        
        // imprimo el nombre del cliente
        System.out.println("\nCliente: " + cliente.getNombre());
        
        // imprimo las reservas del cliente
        for(int i = 0; i < reservasCliente.size(); i++){
            System.out.println(reservasCliente.get(i).toStringCliente());
        }
        
        // creo un empleado
        
        Empleado empleado = new Empleado("Juan");
        
        // añado el empleado al hotel
        hotel.addEmpleado(empleado);
        
        // imprimir empleados del hotel
        
        System.out.println("Empleados: ");
        
        for(int i = 0; i < hotel.getEmpleados().size(); i++){
            System.out.println(hotel.getEmpleados().get(i).getNombre());
        }
        
        // añado al hotel dos habitaciones
        hotel.addHabitacion(0, 1);
        hotel.addHabitacion(1, 2);
        
        System.out.println("La habitacion donde cabe 3 persona es: ");
        System.out.println(hotel.buscarHabitacionCapacidad(3));
        
        System.out.println("La habitacion donde cabe 1 persona es: ");
        System.out.println(hotel.buscarHabitacionCapacidad(1));
    }
}
