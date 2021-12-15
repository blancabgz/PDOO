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
public abstract class Sorpresa {
    private int valor;
    private MazoSorpresas mazo;
    
    
    // Metodo para informar al diario de la sorpresa que se ha aplicado al jugador
    protected void informe(int actual, ArrayList<Jugador> todos, String texto){
        Diario.getInstance().ocurreEvento("se está aplicando la sorpresa. Jugador " + todos.get(actual).getNombre() + " " + texto);
    }
 
    // Segun el tipo de sorpresa, llama a un metodo o a otro
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);
    
    public abstract String toString();

    
}