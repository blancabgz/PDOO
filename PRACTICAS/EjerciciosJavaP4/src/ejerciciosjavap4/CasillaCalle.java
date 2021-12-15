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
public class CasillaCalle extends Casilla{
    private int numCasas;
    private String nombre;

    public CasillaCalle(String nombre, int num) {
        super(nombre);
        this.numCasas = num;
    }
    
    /*
    boolean recibeJugador(){
        System.out.println("Soy una casilla calle y he recibido un jugador");
        return true;
    }
    */
    
    // reutilizando el codigo del padre
    boolean recibeJugador(){
        if(super.recibeJugador()){
            System.out.println("y ademas soy una casilla calle");
            return true;
        }
        return false;
    }
    
    void construirCasa(){
        numCasas++;
        System.out.println("El numero de casas que tiene son " + this.numCasas);
    }
}
