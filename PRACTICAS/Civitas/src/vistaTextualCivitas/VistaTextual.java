package vistaTextualCivitas;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  
  // Avisa al usuario indicandole que pulse una tecla
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

    @Override
    public void actualiza() {
        ArrayList<Jugador> jugadores;
        System.out.println(juegoModel.getJugadorActual().toString()); // este metodo muestra las propiedades del jugador actual y la casilla donde se encuentra
        if(juegoModel.finalDelJuego()){
            jugadores = juegoModel.ranking();
            for(int i = 0; i < jugadores.size(); i++){
                jugadores.get(i).getNombre();
            }
        }
    }

    @Override
    public Respuesta comprar() {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Si");
        lista.add("No");
        int opcion_elegida = menu(juegoModel.getJugadorActual().getCasillaActual() + "¿Desea comprar esta calle?", lista);
        return (Respuesta.values()[opcion_elegida]);
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Contruir una casa");
        lista.add("Construir un hotel");
        lista.add("Terminar");
        
        
        int opcionElegida = menu ("¿Que gestion inmobiliaria desea realizar? (Introduce un numero)", lista);
        
        return (OperacionInmobiliaria.values()[opcionElegida]);
    }

    @Override
    public int elegirPropiedad() {
        int eleccion;
        int numeroPropiedades = juegoModel.getJugadorActual().cantidadCasasHoteles();
        
        ArrayList<String> lista = new ArrayList<String>();
        for(int i = 0; i < numeroPropiedades; i++){
            lista.add("" + i + "");
        }

        eleccion = menu("¿Sobre que propiedad quieres hacer la gestión seleccionada?", lista);
      
        return eleccion;  
        
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operación) {
        System.out.println(operación);
    }

    @Override
    public void mostrarEventos() {
        ArrayList<String> eventos = Diario.getInstance().getEventos();
        int numEventos = eventos.size();
        while(numEventos > 0){
            for(int i = 0; i < numEventos; i++){
                System.out.println(eventos.get(i));
            }
        }
    }

}
