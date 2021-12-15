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
    private Hacienda hacienda;
    
    // Constructor que inicializa el grupo de jugadores, crea el destor de estados y fija el estado actual a inicial. Por otro lado pone el debug del dado y se decide
    // quien inicia el juego. Por último creamos el mazo y el tablero. 
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        Jugador jugador;
        jugadores = new ArrayList<>();
        for (int i = 0; i < nombres.size(); i++) {
            jugador = new Jugador(nombres.get(i)); // creo un objeto jugador con el nombre que me pasan por parametro
            jugadores.add(jugador); // añado al array jugador
        }
        this.gestor = new GestorEstados(); 
        this.estado = this.gestor.estadoInicial(); // se pone el gestor de estados al estado inicial (inicio turno)
        Dado.getInstance().setDebug(debug); // ponemos el dado en el modo debug que nos indique
        
        this.indiceJugadorActual = Dado.getInstance().quienEmpieza(nombres.size()); // el dado elige el jugador que empieza
        
        this.mazo = new MazoSorpresas(debug);
        
        inicializaTablero(mazo);
        inicializaMazoSorpresas();
        
        
    }
    
    // Método para crear tablero e introducir los diferentes tipos de casillas
    
    private void inicializaTablero(MazoSorpresas mazo){
        this.tablero = new Tablero();
        this.tablero.anadeCasilla(new Casilla("SALIDA"));
        
        this.tablero.anadeCasilla(new CasillaCalle("Ronda de Valencia", 60, 50, 2));
        this.tablero.anadeCasilla(new CasillaSorpresa("SORPRESA", this.mazo));
        this.tablero.anadeCasilla(new CasillaCalle("Plaza Lavapiés", 60,50,4));
        this.tablero.anadeCasilla(new CasillaCalle("Glorieta 4 caminos", 100,50,6));
        this.tablero.anadeCasilla(new CasillaCalle("Avenida Reina Victoria", 120,50,8));
        
        this.tablero.anadeCasilla(new CasillaSorpresa("SORPRESA", this.mazo));
        this.tablero.anadeCasilla(new CasillaCalle("Glorieta de Bilbao", 140, 100, 10));
        this.tablero.anadeCasilla(new CasillaCalle("Calle Fuencarral", 160, 100, 12));
        this.tablero.anadeCasilla(new CasillaCalle("Calle Felipe II", 180, 100, 14));
        this.tablero.anadeCasilla(new Casilla("ZONA LIBRE"));
        
       
        this.tablero.anadeCasilla(new CasillaCalle("Avenida de América", 220, 150, 18));
        this.tablero.anadeCasilla(new CasillaCalle("Calle María de Molina", 220, 150, 18));
        this.tablero.anadeCasilla(new CasillaSorpresa("SORPRESA", this.mazo));
        this.tablero.anadeCasilla(new CasillaCalle("Calle Cea Bermudez", 240, 150, 20));
        this.tablero.anadeCasilla(new CasillaCalle("Avenida Reyes Catolicos", 260, 150, 22));
        this.tablero.anadeCasilla(new CasillaCalle("Plaza de Espana", 280, 150, 24));
      
        this.tablero.anadeCasilla(new CasillaSorpresa("SORPRESA", this.mazo));
        this.tablero.anadeCasilla(new CasillaCalle("Paseo de la Castellana", 350, 200, 35));
        this.tablero.anadeCasilla(new CasillaCalle("Paseo del Prado", 400, 200, 50));
       
    }
    
    // Metodo para introducir las diferentes sorpresas al mazo
    
    private void inicializaMazoSorpresas(){
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Paga por gastos escolares", -1000));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Recibes el rescate por el seguro de tus edificios", 990));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Te pagan por intereses", 100));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Has ganado un concurso de crucigramas", 1000));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Multa por embriaguez", -2000));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Multa por exceso de velocidad", -1500));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "La inspección de calles te obliga a hacer reparaciones", -1500));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Paga el seguro por cada casa", -2000));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Ganas un concurso de edificios, te dan 300 por edificio", 300));
        this.mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Es tu cumpleaños, recibes 100 por cada edificio ", 100));   
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
       this.estado = gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }
    
    // Metodo para construir una casa al jugador actual
    public boolean contruirCasa(int ip){
        return getJugadorActual().construirCasa(ip);
    }
    
    // Metodo para construir un hotel al jugador actual
    public boolean construirHotel(int ip){
        return getJugadorActual().construirHotel(ip);
    }
    
    // Método que comprueba si algún jugador ha caido en banca rota, y en ese caso, se finaliza el juego
    public boolean finalDelJuego(){
        for(int i = 0; i < jugadores.size(); i++){ // recorre todos los jugadores
            if(jugadores.get(i).enBancarrota()){ // devuelve si el jugador esta en bancarrota, en caso de ser true, finaliza el juego
                return true;
            }
        }
        return false;
    }
    
    // Ordena a los jugadores según su saldo
    // Le he cambiado la visibilidad porque en la vista necesitamos un ranking de los jugadores según el saldo. No hay problema en principio porque en esta clase no se 
    // cambia ningun valor, sino que se devuelve una información
    public ArrayList<Jugador> ranking(){
        Collections.sort(this.jugadores);
        return this.jugadores;
    }

    
    // Cuenta los pasos por salida, y si lo hay, premia al jugador
    private void contabilizarPasosPorSalida(Jugador jugador){
        while(tablero.computarPasoPorSalida()){ 
           jugador.pasaPorSalida();
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
        Jugador jugadorActual = getJugadorActual(); // obtenemos el jugador actual
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado); // calculamos la siguiente operacion del jugador segun el estado
        
        if(operacion == OperacionJuego.PASAR_TURNO){ // si la operacion es pasar turno
            this.pasarTurno(); // pasamos turno
            this.siguientePasoCompletado(operacion); 
        }else if(operacion == OperacionJuego.AVANZAR){ // si es avanzar
            avanzaJugador(); // avanza jugador
            siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
    // Metodo para que el jugador avance casillas
    private void avanzaJugador(){
        Jugador jugadorActual = this.getJugadorActual();// obtenemos el jugador actual
        int posicionActual = jugadorActual.getCasillaActual(); // obtenemos la posicion actual del jugador
        int tirada = Dado.getInstance().tirar(); // tiramos el dado
        Diario.getInstance().ocurreEvento("Ha salido una tirada de " + tirada + " para el jugador " + jugadorActual.getNombre()); // informamos al diario
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada); //calculamos la posicion nueva del jugador en el tablero
        Casilla casilla = tablero.getCasilla(posicionNueva); // guardamos la casilla
        
        contabilizarPasosPorSalida(jugadorActual); // contabilizamos pasos por salida 
        jugadorActual.moverACasilla(posicionNueva); // movemos al jugador a la casilla
        casilla.recibeJugador(indiceJugadorActual, jugadores);  
    }
    
    // Metodo para comprar una casilla
    public boolean comprar(){
        boolean res = false;
        Jugador jugadorActual = getJugadorActual(); // obtenemos el jugador actual
        int numCasillaActual = jugadorActual.getCasillaActual(); // obtenemos la casilla actual
        Casilla casilla = tablero.getCasilla(numCasillaActual); 
        res = jugadorActual.comprar(((CasillaCalle) casilla)); // llamamos al metodo comprar de jugador para comprobar si puede comprar, si devuelve true es que ya está comprada
        return res;
    }
    
}
