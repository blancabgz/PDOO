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
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    
    protected Tablero(){
        casillas = new ArrayList<Casilla>();
        Casilla salida = new Casilla(TipoCasilla.DESCANSO, "Salida", 0, 0, 0);
        casillas.add(salida);
        
        porSalida = false;
    }
    
    // devuelve true si la casilla es válida. Como hay 20 casillas devuelve true si está entre 0 y 19 incluidos.
    private boolean correcto(int numCasilla){
        if(numCasilla < 20 && numCasilla >= 0){
            return true;
        }
        
        return false;
    }
    
    // devuelve el atributo de salida y lo pone en false
    protected boolean computarPasoPorSalida(){
        boolean copiaSalida = porSalida;
        porSalida = false;
        return copiaSalida;
    }
    
    protected void anadeCasilla(Casilla casilla){
        boolean calleRepetida;
        // comparo si los dos objetos tienen los mismos valores, es decir, es la misma casilla
        for(int i = 0; i < casillas.size(); i++){
            if(casillas.get(i).equals(casilla)){
                casillas.add(casilla);
            }
        }
    }
    
    // devuelve la casilla si el indice pasado por parámetro es válido
    protected Casilla getCasilla(int numCasilla){
        // compruebo si se trata de un indice válido
        if(!correcto(numCasilla)){
            return null; 
        }
        return casillas.get(numCasilla - 1);
    }
    
    
    
    
    
    
    
    
    
    
}
