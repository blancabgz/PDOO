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
public class CasillaSorpresa extends Casilla{
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;
    
    // Metodo que inializa los atributos por defecto
    private void init(){
        this.sorpresa = null;
    }
    
    // Constructor por parámetros
    CasillaSorpresa (String nombre, MazoSorpresas mazo){
        super(nombre);
        this.mazo = mazo;
        init();
    }
    
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        sorpresa = mazo.siguiente();
        this.informe(actual, todos);
        sorpresa.aplicarAJugador(actual, todos);
    }
    
    public String toString() {
        String texto = super.toString();
        return texto + " se aplica la sorpresa " + sorpresa.toString(); 
    }
}