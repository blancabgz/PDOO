/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import civitas.CivitasJuego;

/**
 *
 * @author Blanca
 */
public class TestP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CivitasView civitasview = new CivitasView();
        
        CapturaNombres captura = new CapturaNombres(civitasview, true);
        ArrayList<String> nombres = new ArrayList<>();
        nombres = captura.getNombres();
        
        CivitasJuego civitas = new CivitasJuego(nombres,false);
        
        Controlador controlador = new Controlador(civitas, civitasview);
        civitasview.setCivitasJuego(civitas);
        controlador.juega();
    }
    
}
