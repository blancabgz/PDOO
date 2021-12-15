/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blanca
 */

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;
import vistaTextualCivitas.VistaTextual;

public class juegoTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creo el array con los nombres de los jugadores
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Blanca");
        nombres.add("Juanjo");
        nombres.add("Raquel");
        
        CivitasJuego juego = new CivitasJuego(nombres, false);
        VistaTextual vista = new VistaTextual(juego);
        Controlador controlador = new Controlador(juego,vista);
        controlador.juega();
    }
    
}
