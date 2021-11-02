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
public class Sorpresa {
    private String texto;
    private int valor;
    private MazoSorpresas mazo;
    private TipoSorpresa tipo;
    
    // Constructor de tipo Sorpresa por parámetros
    Sorpresa(TipoSorpresa tipo, String texto, int valor){
        this.tipo = tipo;
        this.texto = texto;
        this.valor = valor;
    }
    
    // Metodo para informar al diario de la sorpresa que se ha aplicado al jugador
    private void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Se está aplicando la sorpresa " + this.texto + " al jugador " + todos.get(actual).getNombre());
    }
    
    // Metodo para informar al diario de la sorpresa y modificar el saldo del jugador con el valor de la sorpresa
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        todos.get(actual).modificaSaldo((float)this.valor);
    }
    // Metodo para informar al diario de la sorpresa y modificar el saldo del jugador con el valor de la sorpresa pero añadiendo que es segun el numero de casas y hoteles que tenga
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
        todos.get(actual).modificaSaldo((this.valor) * todos.get(actual).cantidadCasasHoteles());
    }
    
    // Segun el tipo de sorpresa, llama a un metodo o a otro
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (this.tipo == TipoSorpresa.PAGARCOBRAR) {
            aplicarAJugador_pagarCobrar(actual, todos);
        }else{
            aplicarAJugador_porCasaHotel(actual, todos);
        }
    }
    
    public String toString(){
        return "Sorpresa: " + this.texto;
    }

    
}
