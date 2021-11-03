/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Blanca
 */
public class CivitasJuego {
    private int indiceJugadorActual;
    private MazoSorpresas mazo;
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private EstadoJuego estado;
    private GestorEstados gestor;
    
    // Constructor que inicializa el grupo de jugadores, crea el destor de estados y fija el estado actual a inicial. Por otro lado pone el debug del dado y se decide
    // quien inicia el juego. Por último creamos el mazo y el tablero. 
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        Jugador jugador;
        for (int i = 0; i < nombres.size(); i++) {
            jugador = new Jugador(nombres.get(i));
            jugadores.add(jugador);
        }
        this.gestor = new GestorEstados();
        this.estado = this.gestor.estadoInicial();
        Dado.getInstance().setDebug(debug);
        
        this.indiceJugadorActual = Dado.getInstance().quienEmpieza(nombres.size());
        
        this.mazo = new MazoSorpresas(debug);
        
        this.tablero = new Tablero();
        
        
    }
    
    // Método para crear tablero e introducir los diferentes tipos de casillas
    
    private void inicializaTablero(MazoSorpresas mazo){
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.DESCANSO, "SALIDA"));
        
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Ronda de Valencia", 60, 50, 2));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.SORPRESA, "SORPRESA", this.mazo));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Plaza Lavapiés", 60,50,4));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Glorieta 4 caminos", 100,50,6));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Avenida Reina Victoria", 120,50,8));
        
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.SORPRESA, "SORPRESA", this.mazo));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Glorieta de Bilbao", 140, 100, 10));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Calle Fuencarral", 160, 100, 12));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Calle Felipe II", 180, 100, 14));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.DESCANSO, "ZONA LIBRE"));
        
       
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Avenida de América", 220, 150, 18));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Calle María de Molina", 220, 150, 18));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.SORPRESA, "SORPRESA", this.mazo));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Calle Cea Bermúdez", 240, 150, 20));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Avenida Reyes Católicos", 260, 150, 22));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Plaza de España", 280, 150, 24));
      
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.SORPRESA, "SORPRESA", this.mazo));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Paseo de la Castellana", 350, 200, 35));
        this.tablero.anadeCasilla(new Casilla(TipoCasilla.CALLE, "Paseo del Prado", 400, 200, 50));
       
    }
    
    // Metodo para introducir las diferentes sorpresas al mazo
    
    private void inicializaMazoSorpresas(){
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Paga por gastos escolares", -100));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Recibes el rescate por el seguro de tus edificios", 150));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Te pagan por intereses", 50));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Has ganado un concurso de crucigramas", 100));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Multa por embriaguez", -20));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Multa por exceso de velocidad", -40));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "La inspección de calles te obliga a hacer reparaciones", -40));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Paga el seguro por cada casa", -20));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Ganas un concurso de edificios, te dan 30 por edificio", 30));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Es tu cumpleaños, recibes 10 por cada edificio ", 10));   
    }
    
    // Metodo para obtener el jugador actual
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    // Metodo para pasar turno al siguiente jugador
    private void pasarTurno(){
        this.indiceJugadorActual = (this.indiceJugadorActual + 1) % this.jugadores.size();
    }
    
    // Metodo para obtener el siguiente estado del jugador actual
    public void siguientePasoCompletado(OperacionJuego operacion) {
        gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }
    
    // Metodo para construir una casa al jugador actual
    public boolean contruirCasa(int ip){
        return getJugadorActual().construirCasa(ip);
    }
    
    // Metodo para construir un hotel al jugador actual
    public boolean construirHotel(int ip){
        return getJugadorActual().construirHotel(ip);
    }
    
    // Método que comprueba si algún jugador ha caido en banca rota, y en ese caso, sse finaliza el juego
    public boolean finalDelJuego(){
        for(int i = 0; i < jugadores.size(); i++){
            if(jugadores.get(i).enBancarrota()){
                return true;
            }
        }
        return false;
    }
    
    // Ordena a los jugadores según su saldo
    private ArrayList<Jugador> ranking(){
        Collections.sort(this.jugadores);
        return this.jugadores;
    }
    
    // Cuenta los pasos por salida, y si lo hay, premia al jugador
    private void contabilizarPasosPorSalida(){
        while(tablero.computarPasoPorSalida()){
            jugadores.get(indiceJugadorActual).pasaPorSalida();
        }
    }
    
    // Devuelve el indice del jugador actual
    public int getIndiceJugadorActual(){
        return this.indiceJugadorActual;
    }
    
    // Obtener los jugadores
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    
    // Devuelve el tablero
    public Tablero getTablero(){
        return this.tablero;
    }
    
    // Calcula el siguiente paso del jugador
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado);
        
        if(operacion == OperacionJuego.PASAR_TURNO){
            this.pasarTurno();
            this.siguientePasoCompletado(operacion);
        }else if(operacion == OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
    private void avanzaJugador(){
        Jugador jugadorActual = this.getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        
        this.contabilizarPasosPorSalida();
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);  
    }
    
    public boolean comprar(){
        boolean res = false;
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasillaActual);
        res = jugadorActual.comprar(casilla);        
        return res;
    }
    
}
