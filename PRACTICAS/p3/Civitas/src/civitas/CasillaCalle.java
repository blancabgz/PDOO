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
public class CasillaCalle extends Casilla{
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    private static final float FACTORALQUILERCALLE = 1.0f;
    private static final float FACTORALQUILERCASA = 1.0f;
    private static final float FACTORALQUILERHOTEL = 4.0f;
    private Jugador propietario;
    
    private void init(){
        this.numCasas = 0;
        this.numHoteles = 0;
        this.propietario = null;
    }

    public CasillaCalle(String nombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase) {
        super(nombre);
        this.precioBaseAlquiler = unPrecioAlquilerBase;
        this.precioCompra = unPrecioCompra;
        this.precioEdificar = unPrecioEdificar;
        init();
    }
    
    // Devuelve la cantidad de casas y hoteles
    public int cantidadCasasHoteles(){
        int numCasasHoteles = this.numCasas + this.numHoteles;
        return numCasasHoteles;
    }
    
    // Devuelve true si es el propietario de la casilla el jugador pasado por parámetro
    public boolean esEsteElPropietario(Jugador jugador){
        if (this.propietario.equals(jugador)) { // si es el propietario
            return true; // true
        }
        return false; // si no es, false
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
    
    public String toString() {
        String texto = super.toString();
        return texto + ". \n " + "Precios: " + precioCompra + "\n Edificar " + precioEdificar + "\n Alquiler base: " + precioBaseAlquiler 
                + "\n Casas: " + numCasas + "\n Hoteles: " + numHoteles + "";
    }
    
    // devuelve true si la casilla tiene propietario
    
    public boolean tienePropietario(){
        return propietario != null;
    }
    
    // Si un jugador cae en la casilla, tiene propietario y el jugador que cae en la casilla no es propietario, el propietario recibe el dinero que paga el jugador
    
    public void tramitarAlquiler(Jugador jugador){
        if(tienePropietario() && !esEsteElPropietario(jugador)){ // si tiene propietario y el jugador actual no es el propietario
            jugador.pagaAlquiler(getPrecioAlquilerCompleto()); // jugador actual paga el alquiler
            propietario.recibe(getPrecioAlquilerCompleto()); // propietario recibe el dinero del alquiler
        }
    }
    
    // Derruir casa, si el que lo pide es el propietario y hay el número de casas que se indica
    boolean derruirCasas(int n, Jugador jugador){
        if (esEsteElPropietario(jugador) && numCasas >= n) { // si es el propietario y el numero de casas que tiene es mayor del número de casas que quiere derruir
            numCasas = numCasas - n; // quitamos el numero de casas al numero total de casas que tiene el jugador
            return true; // devolvemos true indicando que se ha realizado correctamente
        }
        
        return false; // no se ha podido derruir
    }
    
    // Le asignamos la propiedad al jugador y paga el precio de compra 
    boolean comprar(Jugador jugador){
        propietario = jugador;
        return propietario.paga(precioCompra);
    }
    
    // El jugador paga el coste de edificar y aumentamos en uno el número de casas
    boolean construirCasa(Jugador jugador){
        jugador.paga(precioEdificar);
        numCasas++;
        return true;
    }
    // El jugador paga el coste de edificar y aumentamos en uno el numero de casas
    boolean construirHotel(Jugador jugador){
        propietario.paga(precioEdificar);
        numHoteles++;
        return true;
    }
    
    // Comprar casilla calle: si la casilla no tiene propietario, mira si el jugador puede comprar casilla
    // Si tiene propietario, el jugador paga el alquiler por caer ahi
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        super.informe(actual, todos);
        Jugador jugador = todos.get(actual);
        if(!this.tienePropietario()){
            jugador.puedeComprarCasilla();
        }else{
            this.tramitarAlquiler(jugador);
        }
    }
    
}
