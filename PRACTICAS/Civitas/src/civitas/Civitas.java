/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author Blanca
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Casilla casilla = new Casilla(TipoCasilla.CALLE, "Gran Vía", 1000, 1000, 300);
        
        String salida = casilla.toString();
        
        System.out.println(salida);
        
    }
    
}
