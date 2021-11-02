/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.lang.Float;

/**
 *
 * @author Blanca
 */
public class Jugador implements Comparable<Jugador>{
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    protected static int HotelesMax = 4;
    protected static float PasoPorSalida = 1000;
    private static float SaldoInicial = 7500;
    private static int ModificadorSaldo = -1;
    private ArrayList<Casilla> propiedades;
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    
    // Constructor por parámetros
    Jugador(String nombre){
        this.nombre = nombre;
        this.saldo = SaldoInicial;
        this.casillaActual = 0;
        this.puedeComprar = false;
        propiedades = new ArrayList<>();
    }
    
    // Constructor por copia
    protected Jugador(Jugador otro){
        this.nombre = otro.nombre;
        this.saldo = otro.getSaldo();
        this.casillaActual = 0;
        this.puedeComprar = false;
        
    }
    
    // Devolver el saldo 
    protected float getSaldo(){
        return this.saldo;
    }
    
    // Devolver el numero del jugador
    String getNombre() {
        return this.nombre;
    }
    
    // Devuelve el numero maximo de casas
    private int getCasasMax(){
        return CasasMax;
    }
    
    // Devuelve el numero de casas por hotel
    int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    // Devuelve la casilla actual donde se encuentra el jugadir
    int getCasillaActual(){
        return casillaActual;
    }
    
    // Devuelve el número de hoteles maximo
    private int getHotelesMax(){
        return HotelesMax;
    }
    
    // Devuelve el precio de pasar por salida
    private float getPrecioPasoSalida(){
        return PasoPorSalida;
    }
    // Devuelve las propiedades de las casillas
    protected ArrayList<Casilla> getPropiedades(){
        return this.propiedades;
    }
    
    // Devuelve la cantidad de hoteles y casas que tiene el jugador
    int cantidadCasasHoteles(){
        int num = 0;
        
        for(int i = 0; i < this.propiedades.size(); i++){
            num += this.propiedades.get(i).cantidadCasasHoteles();
        }
        
        return num;
    }
    // Devuelve true si puede comprar 
    boolean getPuedeComprar(){
        return this.puedeComprar;
    }
    
    // Devuelve true si el jugador se encuentra en bancarrota
    boolean enBancarrota(){
        if (saldo >= 0) {
            return false;
        }
        return true;
    }
    
    // Devuelve true si tiene saldo para edificar y tiene menos que el número maximo de casas
    private boolean puedoEdificarCasa(Casilla propiedad){
        if(propiedad.getNumCasas() >= CasasMax){
            return false;
        }else{
            if(propiedad.getPrecioEdificar() >= this.saldo){
                return true;
            }else{
                return false;
            }
        }
    }
    
    // Devuelve true si tiene las casas necesarias para derrurir y edificar un hotel y además teiene el saldo necesario
    private boolean puedoEdificarHotel(Casilla propiedad){
        if(propiedad.getNumCasas() >= CasasPorHotel){
            if(propiedad.getPrecioEdificar() >= this.saldo){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    // Comprueba si el indice en valido dentro de las propiedades del jugador
    private boolean existeLaPropiedad(int ip){
        boolean existe = false;
        if (propiedades.get(ip) != null) {
            existe = true;
        }
        return existe;
    }
    
    // Devuelve true el jugador puede comprar la casilla
    boolean puedeComprarCasilla(){
        this.puedeComprar = true;
        return this.puedeComprar;
    }
    
    // Metódo que modifica el saldo del jugador cuando paga
    boolean paga(float cantidad){
        return this.modificaSaldo(cantidad * ModificadorSaldo);
    }
    
    // Metodo para pagar el alquiler
    boolean pagaAlquiler(float cantidad){
        return this.paga(cantidad);
    }
    
    // Metodo que modifica el saldo del jugador con la cantidad que recibe
    boolean recibe(float cantidad){
        return modificaSaldo(cantidad);
    }
    
    // método que añade o resta saldo del jugador y además informa al diario
    boolean modificaSaldo(float f) {
        this.saldo += f;
        Diario.getInstance().ocurreEvento("El saldo del jugador " + this.nombre + "se ha incrementado " + f + " y el saldo final es " + this.saldo);
        return true;
    }
    
    // Método para mover a la casilla deseada
    boolean moverACasilla(int c) {
        casillaActual = c;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " se ha movido a la casilla " + c );
        return true;
    }
    
    // metodo para comprobar si el jugador puede gastar dinero
    private boolean puedoGastar(float precio){
        if(this.saldo >= precio){
            return true;
        }else{
            return false;
        }
    }
    
    // metodo para comprobar si el jugador tiene propiedades
    boolean tieneAlgoQueGestionar(){
        if (!propiedades.isEmpty()) {
            return true;
        }
        return false;
    }
    
    // Metodo para informar que el jugador ha pasado por casilla y recibido el dinero
    boolean pasaPorSalida(){
        if (this.recibe(PasoPorSalida)) {
            Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " ha pasado por salida");
        }
        return true;
    }
    
    public String toString(){
        return "El jugador " + this.getNombre() + " tiene " + this.cantidadCasasHoteles() + " propiedades y se encuentra en la casilla " + this.getCasillaActual();
    }
    


     // return -1 si jugador < otro y return 1 si es mayor o igual
    @Override
    public int compareTo(Jugador otro) {
        return Float.compare(this.saldo, otro.getSaldo());
    }
    
    boolean comprar(Casilla titulo){
        boolean result = false;
        if(puedeComprar){
           float precio = titulo.getPrecioCompra();
            if (puedoGastar(precio)) {
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + this + " compra la propiedad " + titulo);
                puedeComprar = false;
            }else{
                Diario.getInstance().ocurreEvento("El jugador " + this + " no tiene saldo para comprar la propiedad " + titulo);
            }
        }
        return result;
    }

    boolean construirCasa(int ip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean construirHotel(int ip) {
        boolean result = false;
        boolean puedoEdificarHotel = false;
        float precio;
        Casilla propiedad;
        if (existeLaPropiedad(ip)) {
            propiedad = propiedades.get(ip);
            precio = propiedad.getPrecioEdificar();
            
            if(puedoGastar(precio) && getHotelesMax() < propiedad.getNumHoteles() && propiedad.getNumCasas() >= getCasasPorHotel()){
                  puedoEdificarHotel = true;
            }
        }
        
        return result;
    }
    
    
    
    

    
}