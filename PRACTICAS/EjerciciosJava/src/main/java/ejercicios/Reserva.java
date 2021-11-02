/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

/**
 *
 * @author Blanca
 */
public class Reserva {
    private final String fechaEntrada;
    private final String fechaSalida;
    private final Cliente cliente;
    private final Hotel hotel;
    private String reservaString;
    
    
    public Reserva(String fechaEntrada, String fechaSalida, Cliente cliente, Hotel hotel){
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.hotel = hotel;
    }
    
    public String getFechaEntrada(){
        return this.fechaEntrada;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public String toStringHotel(){
        reservaString =  "\nNombre cliente: " + getCliente().getNombre() + ".\n La fecha de entrada es: " + getFechaEntrada();
        return reservaString;
    }
    
    public String toStringCliente(){
        reservaString =  "La fecha de entrada es: " + getFechaEntrada();
        return reservaString;
    }
}
