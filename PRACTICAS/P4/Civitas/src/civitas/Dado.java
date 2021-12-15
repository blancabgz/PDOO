/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.Random;
//generar un numero aleatorio con Random --> (int) (random.nextDouble() * cantidad_números_rango + término_inicial_rango)


/**
 *
 * @author Blanca
 */
public class Dado {
    static final protected Dado instance = new Dado();
    private static int VALORESDADO = 6; // hay 6 números en el dado, lo creo static porque no debe variar el número del dado
    // EXAMEN : He cambiado el valor del debug para poder ver que se aplique la multa
    private static int VALORDEBUG = 5; // el numero más pequeño de un dado es el 1. Lo he puesto static por lo mismo que antes
    // FIN EXAMEN
    private Random random;
    private int ultimoResultado;
    private boolean debug;
    
    private Dado(){
        random = new Random();
        ultimoResultado = 0;
        debug = false;
    }
    
    static public Dado getInstance() {
        return instance;
    }
    
    int tirar(){
        // si esta en modo debug, las tiradas serán de una en una
        if (debug) {
            ultimoResultado = VALORDEBUG;
            return ultimoResultado;
        }
        // si está en modo no debug, genera un numero alteatorio de 1 a 6
        ultimoResultado = (int) (random.nextDouble() * VALORESDADO + VALORDEBUG);
        return ultimoResultado;
        
    }
    
    // Devuelve el jugador que empieza aleatoriamente
    int quienEmpieza(int n){
        int empieza = 0;
        empieza = (int)(random.nextDouble() * n); // genera un numero aleatorio entre 0 y n-1
        return empieza;
    }
    // Activa o desactiva el modo debg
    public void setDebug(boolean d){
        String diario;
        debug = d;
        if (d) {
            diario = "Modo debug activado";
        }else{
           diario = "Modo debug desactivado";
        }
        Diario.getInstance().ocurreEvento(diario);
    }
    
    // Obtiene el último resultado del dado
    int getUltimoResultado(){
        return ultimoResultado;
    }
    
    
    
}
