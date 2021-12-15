
import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;
import vistaTextualCivitas.VistaTextual;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author blancabrilgonz
 */
public class juegoExamen {
    public static void main(String[] args) {
        // EXAMEN
        
        // HE CREADO EL MISMO MAIN USANDO VISTA/CONTROLADOR PERO HE ACTIVO EL MODO DEBUG, DE ESTA MANERA, EL PRIMER JUGADOR CAE DIRECTAMENTE EN CONTROL
        // POLICIAL, SI SE MIRA LA SALIDA, SE VE QUE EL MÉTODO SE APLICA CORRECTAMENTE Y SE LE RESTA AL JUGADOR EL VALOR DE LA MULTA
        
        
        // creo el array con los nombres de los jugadores
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Blanca");
        
        CivitasJuego juego = new CivitasJuego(nombres, true);
        VistaTextual vista = new VistaTextual(juego);
        Controlador controlador = new Controlador(juego,vista);
        controlador.juega();
    }
}
