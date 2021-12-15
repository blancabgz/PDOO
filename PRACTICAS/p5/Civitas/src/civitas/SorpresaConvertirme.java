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
public class SorpresaConvertirme extends Sorpresa {
    private String texto;

    public SorpresaConvertirme(String texto){
        this.texto = texto;
    }
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        super.informe(actual, todos, this.texto);
        JugadorEspeculador especulador = todos.get(actual).convertir();
        todos.set(actual,especulador);
    }

    @Override
    public String toString() {
        return "Sorpresa " + this.texto + " ";
    }
    
}
