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
public class GestionInmobiliaria {
    private final OperacionInmobiliaria gestion;
    private final int indicePropiedad;
    
    // constructor por parametros
    public GestionInmobiliaria(OperacionInmobiliaria gest, int indice){
        this.gestion = gest;
        this.indicePropiedad = indice;
    }
    
    // obtenemos el indice de la propiedad
    public int getIndicePropiedad(){
        return indicePropiedad;
    }
    
    // obtenemos la gestion
    public OperacionInmobiliaria getOperacion(){
        return gestion;
    }
    
}
