/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosjavap4;

/**
 *
 * @author Blanca
 */
public class EjercicioJavaP4_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = "casilla_Calle";
        int numcasas = 2;
        CasillaCalle casilla1 = new CasillaCalle(nombre, 2);
        Casilla casilla2 = casilla1;
        
        casilla1.recibeJugador();
        casilla2.recibeJugador();
        
        casilla1.construirCasa();
        ((CasillaCalle)casilla2).construirCasa();
    }
    
}
