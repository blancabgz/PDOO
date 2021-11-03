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
    private TipoCasilla tipo;
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    private static final float FACTORALQUILERCALLE = 1.0f;
    private static final float FACTORALQUILERCASA = 1.0f;
    private static final float FACTORALQUILERHOTEL = 4.0f;
    private static final int JUGADORES = 4;
    private Jugador propietario;
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;
    
    // Constructor por parámetros
    
    private void init(){
        this.numCasas = 0;
        this.numHoteles = 0;
        this.propietario = null;
        this.sorpresa = null;
    }
    
    Casilla (TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        this.tipo = unTipo;
        this.nombre = unNombre;
        
        this.precioCompra = unPrecioCompra;
        this.precioEdificar = unPrecioEdificar;
        this.precioBaseAlquiler = unPrecioAlquilerBase;
        
        init();
    }
    
    Casilla(TipoCasilla tipo ,String nombre){
        this.nombre = nombre;
        this.tipo = tipo;
        
        init();
    }
    
    Casilla(TipoCasilla tipo, String nombre, MazoSorpresas mazo){
        this.tipo = tipo;
        this.nombre = nombre;
        this.mazo = mazo;
        init();
    }
    
    // Devuelve la cantidad de casas y hoteles
    
    public int cantidadCasasHoteles(){
        int numCasasHoteles = this.numCasas + this.numHoteles;
        return numCasasHoteles;
    }
    
    // Devuelve true si es el propietario de la casilla el jugador pasado por parámetro
    
    public boolean esEsteElPropietario(Jugador jugador){
        if (this.propietario.equals(jugador)) {
            return true;
        }
        return false;
    }
    
     
    // Devuelve el tipo de casilla
    public TipoCasilla getTipo(){
        return this.tipo;
    }
    
    // Devuelve el nombre de la casilla
    public String getNombre(){
        return nombre;
    }
    
    // Devuelve el precio de compra de la casilla
    protected float getPrecioCompra(){
        return precioCompra;
    }
    
    // Devuelve el numero de casas que tiene la casilla
    int getNumCasas(){
        return numCasas;
    }
    
    // Devuelve el numero de hoteles que tiene la casilla
    int getNumHoteles(){
        return numHoteles;
    }
    
    // Devuelve el precio del alquiler completo de la casilla
    float getPrecioAlquilerCompleto(){
        float precio_alquiler = precioBaseAlquiler * (FACTORALQUILERCALLE * (FACTORALQUILERCASA + numCasas + (FACTORALQUILERHOTEL*numHoteles)));
        return precio_alquiler;
    }
    
    // devuelve el precio de edificar la casa o el hotel
    float getPrecioEdificar(){
        return this.precioEdificar;
    }
    
    // Imprime toda la información sobre la casilla
    public String toString() {
        return " Calle " + nombre + ". \n " + "Precios: " + precioCompra + "\n Edificar " + precioEdificar + "\n Alquiler base: " + precioBaseAlquiler 
                + "\n Casas: " + numCasas + "\n Hoteles: " + numHoteles + "";
    } 
    
    // Informa al diario del jugador que ha caido en la casilla
    
    void informe(int actual, ArrayList<Jugador> todos){
        if(todos.size() <= JUGADORES && todos.size() >= 1){
            Diario.getInstance().ocurreEvento("El jugador " + todos.get(actual) + " ha caido en la casilla " + this.toString());  
        }
    }
    
    // devuelve true si la casilla tiene propietario
    
    public boolean tienePropietario(){
        return propietario != null;
    }
    
    // Si un jugador cae en la casilla, tiene propietario y el jugador que cae en la casilla no es propietario, el propietario recibe el dinero que paga el jugador
    
    public void tramitarAlquiler(Jugador jugador){
        if(tienePropietario() && !esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(getPrecioAlquilerCompleto());
            propietario.recibe(getPrecioAlquilerCompleto());
        }
    }
    
    // Derruir casa, si el que lo pide es el propietario y hay el número de casas que se indica
    boolean derruirCasas(int n, Jugador jugador){
        if (esEsteElPropietario(jugador) && numCasas >= n) {
            numCasas = numCasas - n;
            return true;
        }
        
        return false;
    }
    
    
    boolean comprar(Jugador jugador){
        propietario = jugador;
        return propietario.paga(precioCompra);
    }
    
    boolean construirCasa(Jugador jugador){
        jugador.paga(precioEdificar);
        numCasas++;
        return true;
    }
    
    boolean construirHotel(Jugador jugador){
        propietario.paga(precioEdificar);
        numHoteles++;
        return true;
    }
    
    void recibeJugador(int actual, ArrayList<Jugador> todos){
       switch(this.tipo){
            case CALLE: 
                recibeJugador_calle(actual, todos);
                break;
            case SORPRESA: 
                recibeJugador_sorpresa(actual, todos);
                break;
            case DESCANSO: 
                informe(actual, todos);
                break;
        } 
    }
    
    void recibeJugador_calle(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        Jugador jugador = todos.get(actual);
        if(!this.tienePropietario()){
            jugador.puedeComprarCasilla();
        }else{
            this.tramitarAlquiler(jugador);
        }
    }
    
    void recibeJugador_sorpresa(int actual, ArrayList<Jugador> todos){
        sorpresa = mazo.siguiente();
        this.informe(actual, todos);
        sorpresa.aplicarAJugador(actual, todos);
    }
    
    
}
