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
public class SorpresaPorCasaHotel extends Sorpresa{
        
    private String texto;
    private int valor;
    private MazoSorpresas mazo;
    
    public SorpresaPorCasaHotel(String texto, int valor) {
        this.texto = texto;
        this.valor = valor;
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        this.informe(actual, todos, this.texto);
        todos.get(actual).modificaSaldo((this.valor) * todos.get(actual).cantidadCasasHoteles());
    }

    @Override
    public String toString() {
        return "Sorpresa: " + this.texto;
    }
    
}

