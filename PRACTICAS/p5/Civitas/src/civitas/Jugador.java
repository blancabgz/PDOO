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
    private ArrayList<CasillaCalle> propiedades;
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
        this.propiedades = otro.getPropiedades();
        
    }
    
    // Devolver el saldo 
    public float getSaldo(){
        return this.saldo;
    }
    
    // Devolver el numero del jugador
    // He puesto publico este metodo para poder acceder al nombre de los jugadores
    public String getNombre() {
        return this.nombre;
    }
    
    // Devuelve el numero maximo de casas
    int getCasasMax(){
        return CasasMax;
    }
    
    // Devuelve el numero de casas por hotel
    int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    // Devuelve la casilla actual donde se encuentra el jugadir
    // CAMBIO: la he hecho público para acceder a la casilla actual y asi usarla para obtener información de la casilla para comprarla
    public int getCasillaActual(){
        return casillaActual;
    }
    
    // Devuelve el número de hoteles maximo
    int getHotelesMax(){
        return HotelesMax;
    }
    
    // Devuelve el precio de pasar por salida
    private float getPrecioPasoSalida(){
        return PasoPorSalida;
    }
    // Devuelve las propiedades de las casillas
    // LO PONGO PUBLICO PARA ACCEDER A LAS PROPIEDADES
    public ArrayList<CasillaCalle> getPropiedades(){
        return this.propiedades;
    }
    
    // Devuelve la cantidad de hoteles y casas que tiene el jugador
    public int cantidadCasasHoteles(){
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
    private boolean puedoEdificarCasa(CasillaCalle propiedad){
        if(propiedad.getNumCasas() >= CasasMax){ // comprueba que no supere el numero de casas maximo
            return false;
        }else{
            if(propiedad.getPrecioEdificar() >= this.saldo){ // si tiene saldo, PUEDE construir
                return true;
            }else{
                return false;
            }
        }
    }
    
    // Devuelve true si tiene las casas necesarias para derrurir y edificar un hotel y además teiene el saldo necesario
    private boolean puedoEdificarHotel(CasillaCalle propiedad){
        if(propiedad.getNumCasas() >= CasasPorHotel){ // obtenemos si tenemos el numero de casas que hacen falta para construir un hotel
            if(propiedad.getPrecioEdificar() >= this.saldo){ // si tenemos saldo podemos edificar el hotel
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
        Diario.getInstance().ocurreEvento("El saldo del jugador " + this.nombre + " se ha modificado " + f + " y el saldo final es " + this.saldo);
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
    
    public JugadorEspeculador convertir(){
        JugadorEspeculador especulador = new JugadorEspeculador(this);
        return especulador;
    }
    
    public String toString(){
        return " " + this.getNombre() + " tiene " + this.cantidadCasasHoteles() + " propiedades y se encuentra en la casilla " + this.getCasillaActual();
    }
    


     // return -1 si jugador < otro y return 1 si es mayor o igual
    @Override
    public int compareTo(Jugador otro) {
        return Float.compare(this.saldo, otro.getSaldo());
    }
    
    // Metodo comprar: comprueba si el jugador puede comprar
    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        if(puedeComprar){ // si esta a true, osea que puede comprar
           float precio = titulo.getPrecioCompra(); // obtenemos el precio de la casilla
            if (puedoGastar(precio)) {
                result = titulo.comprar(this); // compra el jugador actual
                propiedades.add(titulo); // se le añade la casilla a sus propiedades
                Diario.getInstance().ocurreEvento("El jugador " + this + " compra la propiedad " + titulo); //informa en el diario
                puedeComprar = false;
            }else{
                Diario.getInstance().ocurreEvento("El jugador " + this + " no tiene saldo para comprar la propiedad " + titulo);
            }
        }
        return result;
    }

    // Metodo para construir una casa por el jugador
    boolean construirCasa(int ip) {
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        boolean puedoEdificar;
        float precioEdificar;
        int numCasas;
        
        // si existe la propiedad
        if(existe){
            // obtenemos la propiedad
            CasillaCalle propiedad = propiedades.get(ip);
            // comprueba si puede edificar casa
            puedoEdificar = puedoEdificarCasa(propiedad);
            // obtiene el precio de edificar la propiedad
            precioEdificar = propiedad.getPrecioEdificar();
            // obtiene el numero de casas que tiene la propiedad
            numCasas = propiedad.getNumCasas();
            // si puede gastar dinero y ha construido menos del numero maximo de casas
            if(this.puedoGastar(precioEdificar) && numCasas <= getCasasMax() ){
                puedoEdificar = true;
            }
            // si puede edificar
            if(puedoEdificar){
                // se construye casa
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre + " construye casa en la propiedad " + ip);
            }else{
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre+ " no puede construir en la propiedad " + ip );
            }
            
            
        }
        return result;
    }

    boolean construirHotel(int ip) {
        boolean result = false;
        boolean puedoEdificarHotel = false;
        float precio;
        CasillaCalle propiedad;
        if (existeLaPropiedad(ip)) {
            propiedad = propiedades.get(ip);
            precio = propiedad.getPrecioEdificar();
            
            if(puedoGastar(precio) && getHotelesMax() > propiedad.getNumHoteles() && propiedad.getNumCasas() >= getCasasPorHotel()){
                  puedoEdificarHotel = true;
            }
            else{
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " no puede construir un hotel en la propiedad " + ip);
            }
            if(puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye hotel en la propiedad " + ip);
            }
        }
        
        return result;
    }
    
    public boolean soyEspeculador(){
        return false;
    }
    
    
    
    

    
}
