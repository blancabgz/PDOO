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
public class Tablero {
    private ArrayList<Casilla> tablero;
    private boolean porSalida;
    private static final int TOTALCASILLAS = 20;
    private static final int PRIMERACASILLA = 0;
    private static final int ERRORCASILLA = -1;
    
    // construcor por defecto
    public Tablero(){
        tablero = new ArrayList<Casilla>();
        Casilla salida = new Casilla(TipoCasilla.DESCANSO, "Salida", 0, 0, 0);
        tablero.add(salida);
        
        porSalida = false;
    }
    
    // devuelve true si la casilla es válida. Como hay 20 casillas devuelve true si está entre 0 y 19 incluidos.
    private boolean correcto(int numCasilla){
        if(numCasilla < TOTALCASILLAS && numCasilla >= PRIMERACASILLA){
            return true;
        }
        
        return false;
    }
    
    // devuelve el atributo de salida y lo pone en false
    boolean computarPasoPorSalida(){
        boolean copiaSalida = porSalida;
        porSalida = false;
        return copiaSalida;
    }
    
    void anadeCasilla(Casilla casilla){
        boolean calleRepetida;
        // compruebo con contains si el array ya tiene la casilla, si la tiene, pues no la inserta de nuevo
        for(int i = 0; i < tablero.size(); i++){
            if(!tablero.contains(casilla)){
                tablero.add(casilla);
            }
        }
    }
    
    // devuelve la casilla si el indice pasado por parámetro es válido
    public Casilla getCasilla(int numCasilla){
        // compruebo si se trata de un indice válido
        if(!correcto(numCasilla)){
            return null; 
        }
        return tablero.get(numCasilla - 1); // para que las casillas empiecen en 1
    }
    
    public ArrayList<Casilla> getCasillas(){
        return tablero;
    }
    
    // calcula la nueva posición en el tablero
    
    int nuevaPosicion(int actual, int tirada){
        int avance = actual + tirada;
        int casillaFinal = ERRORCASILLA;
        
        if (correcto(avance)) { // si no se pasa de las 20 casillas
            casillaFinal = avance; // se guarda el valor
        }else{
            porSalida = true; // sino es que ha pasado por la salida
            casillaFinal = avance % TOTALCASILLAS; // y se calcula el modulo para saber la casilla
        }
        return casillaFinal;
    }
    
    
    
    
    
    
    
    
}
