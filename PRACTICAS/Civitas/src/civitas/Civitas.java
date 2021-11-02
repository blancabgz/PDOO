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
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numJugadores = 4;
        final int  NUMTIRADASEJ1 = 100; // 100 tiradas
        int valorTirada;
        ArrayList<Integer> probabilidad = new ArrayList<>(); // inicializo el vector para guardar las veces que sale cada jugador
        Tablero tablero = new Tablero();
        Casilla casilla = new Casilla(TipoCasilla.CALLE, "Calle Fernandez", 1000, 100, 100);
        Casilla casilla2 = new Casilla(TipoCasilla.CALLE, "Calle Martinez", 2000, 200, 200);
        String casilla_actual = null;
        int posicion = 0;
        float calle_cara = 0;
        float calle_barata = 0;
        float precio_medio = 0;
        int contador = 0;
        int primer_valor_tablero = 2;
        
        /* 
            
            Ejercicio 1
        
        */ 
        
        System.out.println("\nEjercicio 1");
        // para empezar inicializo el vector a 0
        for(int i = 0; i  < numJugadores; i++){
            probabilidad.add(0);
        }
        
        // bucle para lanzar 100 veces quien empieza
        for(int i = 0; i < NUMTIRADASEJ1; i++){ 
            // obtengo el jugador random que empieza
            valorTirada = Dado.getInstance().quienEmpieza(numJugadores);
            // pongo el valor en la posicion de valorTirada y cojo el valor de la casilla y le sumo 1 --> set(index, valor)
            probabilidad.set(valorTirada, probabilidad.get(valorTirada)+1);
        }
        // imprimir resultados con porcentajes
        System.out.println("\nEJERCICIO 1");
        for(int i = 0 ; i < numJugadores ; i++){
            System.out.println("Jugador numero: " + (i+1) + ", porcentaje: " + (probabilidad.get(i)*1.0) + " %");
        }
        
        /* 
        
            EJERCICIO 2
        
        */ 
        System.out.println("\nEjercicio 2");
        // primero tiramos con el dado en modo no debug
        for(int i = 0; i < 5; i++){
            valorTirada = Dado.getInstance().tirar();
            System.out.println("La tirada en modo no debug ha dado: " + valorTirada);
        }
        
        // activamos el modo debug
        Dado.getInstance().setDebug(true);
        
        // realizamos la tirada en modo debug
        for(int i = 0; i < 5; i++){
            valorTirada = Dado.getInstance().tirar();
            System.out.println("La tirada en modo debug ha dado: " + valorTirada);
        }
        // desactivamos modo debug
        Dado.getInstance().setDebug(false);
        
        /* 
        
            EJERCICIO 3
        
        */
        System.out.println("\nEjercicio 3");
        // realizamos una tirada del dado 
        
        valorTirada = Dado.getInstance().tirar();
        System.out.println("La tirada es: " + valorTirada);
        System.out.println("El ultimo resultado es: " +Dado.getInstance().getUltimoResultado());
        
        /* 
        
            EJERCICIO 4
        
        */
        System.out.println("\nEjercicio 4");
        System.out.println("Tipo Casilla " + TipoCasilla.CALLE);
        System.out.println("TipoSorpresa " + TipoSorpresa.PAGARCOBRAR);
        System.out.println("Estados de juego " + EstadoJuego.DESPUES_AVANZAR);
       
        
        /* 
        
            EJERCICIO 5
        
        */
        System.out.println("\nEjercicio 5");
        // añado las casillas al tablero
        tablero.anadeCasilla(casilla);
        tablero.anadeCasilla(casilla2);
        
        
        casilla_actual = tablero.getCasilla(2).toString();
        System.out.println(casilla_actual);
        
        casilla_actual = tablero.getCasilla(3).toString();
        System.out.println(casilla_actual);
        
        
        
         /* 
        
            EJERCICIO 6
        
        */
        System.out.println("\nEjercicio 6");
         
        // guardo el primer valor de la primera calle
        calle_barata = tablero.getCasilla(primer_valor_tablero).getPrecioCompra();
        
        // recorro las casillas
        for(int i = 1; i < 4; i++){
            if(tablero.getCasilla(i).getTipo() == TipoCasilla.CALLE){ // si es una calle
                
                precio_medio += tablero.getCasilla(i).getPrecioCompra(); // sumo el precio de la compra 
                contador++;
                
                if(tablero.getCasilla(i).getPrecioCompra() > calle_cara){ // si es mas cara que la actual, guardo el valor
                    calle_cara = tablero.getCasilla(i).getPrecioCompra();
                }
                if(tablero.getCasilla(i).getPrecioCompra() < calle_barata){ // si es mas barata que la más barata hasta ahora, guardo el valor
                    calle_barata = tablero.getCasilla(i).getPrecioCompra();
                }
            }
        }
        
        precio_medio /= contador;
        
        System.out.println("La calle más cara vale " + calle_cara);
        System.out.println("La calla más barata vale " + calle_barata);
        System.out.println("El precio medio es " + precio_medio);
        
         /* 
        
            EJERCICIO 7
        
        */
        System.out.println("\nEjercicio 7"); 
        Diario.getInstance().ocurreEvento("Probando el diario"); // creo un evento
        while(Diario.getInstance().eventosPendientes()){ // si hay eventos pendientes
            System.out.println(Diario.getInstance().leerEvento()); // imprimo los eventos guardados en el diario
        }
        
         /* 
        
            EJERCICIO 8
        
        */
        System.out.println("\nEjercicio 8"); 
        
        // pongo la posicion en la casilla de salida (iniciailizado a 0 arriba) y ahora calculo nueva posicion
        
        System.out.println("La posicion actual es " + posicion);
        System.out.println("La posicion final es " + tablero.nuevaPosicion(posicion, Dado.getInstance().tirar()));
        System.out.println("La tirada ha sido " + Dado.getInstance().getUltimoResultado());
        
        System.out.println("La posicion final es " + tablero.nuevaPosicion(Dado.getInstance().getUltimoResultado(), Dado.getInstance().tirar()));
        System.out.println("La tirada ha sido " + Dado.getInstance().getUltimoResultado());
    }
    
}
