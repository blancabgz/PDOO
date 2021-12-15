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
public class SorpresaCobrarPagar extends Sorpresa{
    
    private String texto;
    private int valor;
    private MazoSorpresas mazo;
    
    public SorpresaCobrarPagar(String texto, int valor) {
        this.texto = texto;
        this.valor = valor;
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        super.informe(actual, todos, this.texto);
        todos.get(actual).modificaSaldo((float)this.valor);
    }
    
     @Override
    public String toString() {
        return "Sorpresa: " + this.texto;
    }
    
}
