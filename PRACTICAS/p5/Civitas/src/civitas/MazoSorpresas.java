/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civitas;

import java.util.ArrayList;
import java.util.Collections;
       
/**
 *
 * @author Blanca
 */
public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    // inicializar mazo
    private void init(){
        sorpresas = new ArrayList<Sorpresa>();
        barajada = false;
        usadas = 0;
    }
    
    // constructor por defento
    
    MazoSorpresas(){
        debug = false;
        init();
    }
    
    // constructor por parametro para modo debug
    MazoSorpresas(boolean debug){
        String diario; // variable para guardar el mensaje que se quiere incluir en el diario
        this.debug = debug;
        init();
        if (debug) {
            diario = "Modo debug activado";
        }else{
           diario = "Modo debug desactivado";
        }
        Diario.getInstance().ocurreEvento(diario);
    }
    
    // creo una sorpresa para meterla en el mazo mientras no este barajada
    void alMazo(Sorpresa sorpresa){
        if (!barajada) {
           sorpresas.add(sorpresa);
        }
    }
    
    /* 
    
        Si el mazo no ha sido barajado o si el número de cartas usadas es igual al
        tamaño del mazo, se baraja el mazo (salvo que el modo debug esté activo), se baraja y se inicializa a 0 las cartas usadas.

        Una vez hecho esto, se coge una carta.
    
    */ 
    
    Sorpresa siguiente(){
        Sorpresa ultimaSorpresa;       
        if ((!barajada || usadas == sorpresas.size()) && !debug) {
            Collections.shuffle(sorpresas); // barajar 
            barajada = true;
            usadas = 0;
        }
        usadas++;
        ultimaSorpresa = sorpresas.get(0); // obtengo la primera carta del mazo
        sorpresas.remove(0); // borro la primera carta
        return ultimaSorpresa; 
        
    }


}



