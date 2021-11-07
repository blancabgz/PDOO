/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorCivitas;
        
import civitas.CivitasJuego;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import vistaTextualCivitas.VistaTextual;
import civitas.GestionInmobiliaria;
/**
 *
 * @author Blanca
 */
public class Controlador {
    private CivitasJuego juego;
    private VistaTextual vista;
    
    public Controlador(CivitasJuego juego, VistaTextual vista){
        this.juego = juego;
        this.vista = vista;
    }
    
    public void juega(){
        OperacionJuego operacion;
        Respuesta respuesta;
        OperacionInmobiliaria operacionImb;
        int propiedad;
        
        while(!juego.finalDelJuego()){
            // Mostrar el estado de juego
            vista.actualiza();
            // Hace una pausa para que esperar la interaccion de un usuario entre turno y turno
            vista.pausa();
             operacion = juego.siguientePaso();
            vista.mostrarSiguienteOperacion(operacion);
            
            if(operacion != OperacionJuego.PASAR_TURNO){
               vista.mostrarEventos();
            }
            
            if(!juego.finalDelJuego()){
                 if(operacion == OperacionJuego.COMPRAR){
                    respuesta = vista.comprar();
                    if(respuesta == Respuesta.SI){
                        juego.comprar();
                    }
                    juego.siguientePasoCompletado(operacion);
                }else if(operacion == OperacionJuego.GESTIONAR){
                    operacionImb = vista.elegirOperacion();
                    // si no le ha dado a terminar y tiene propiedades
                    if((operacionImb != OperacionInmobiliaria.TERMINAR)){
                        int eleccion = vista.elegirPropiedad();
                        GestionInmobiliaria gestioninmb = new GestionInmobiliaria(operacionImb,eleccion);
                        if(gestioninmb.getOperacion() == OperacionInmobiliaria.CONSTRUIR_CASA){
                            juego.contruirCasa(eleccion);
                        }else if(gestioninmb.getOperacion() == OperacionInmobiliaria.CONSTRUIR_HOTEL && juego.getJugadorActual().cantidadCasasHoteles() > 0){
                            juego.construirHotel(eleccion);
                        }
                       
                    }else{
                        juego.siguientePasoCompletado(operacion);
                    }
                }
            }
        }
        
        juego.ranking();
        vista.actualiza();
    }
}
