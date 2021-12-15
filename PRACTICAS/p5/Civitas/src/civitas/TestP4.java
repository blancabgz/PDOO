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
public class TestP4 {
    public static void main(String[] args) {
        Jugador jug1 = new Jugador("Blanca");
        CasillaCalle cas = new CasillaCalle("Calle Prueba",10,20,30);
        CasillaCalle cas2 = new CasillaCalle("Calle Prueba2",10,30,30);   
        
        System.out.println(cas.toString());
        System.out.println(jug1.toString());
        
        jug1 = jug1.convertir();
        
        if (jug1.puedeComprarCasilla()){
            jug1.comprar(cas2);
            cas2.construirCasa(jug1);
        }
        
        while(Diario.getInstance().eventosPendientes()){
            System.out.println(Diario.getInstance().leerEvento());
        }
        
        System.out.println(cas.toString());
        System.out.println(jug1.toString());
        
        
    }
}
