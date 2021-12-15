/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosjavap4;

import java.util.ArrayList;

/**
 *
 * @author Blanca
 */
public class EjerciciosJavaP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num_casas = 4;
        Casilla casilla = new Casilla("casilla costa");
        CasillaCalle casilla_calle = new CasillaCalle("casilla playa", num_casas);
        ArrayList<Casilla> tablero = new ArrayList<>();
        
        
        System.out.println("Casilla");
        casilla.recibeJugador();
        System.out.println("Casilla calle");
        casilla_calle.recibeJugador();
       
        //casilla.construirCasa();
        
        casilla_calle.construirCasa();
        
        
        tablero.add(casilla);
        tablero.add(casilla_calle);
        
        //Casilla casilla2 = tablero.get(0);
        //((CasillaCalle)casilla2).construirCasa();
        
        System.out.println("Tablero");
        Casilla casilla_calle2 = tablero.get(1);
        ((CasillaCalle)casilla_calle2).construirCasa();
    }
    
}
