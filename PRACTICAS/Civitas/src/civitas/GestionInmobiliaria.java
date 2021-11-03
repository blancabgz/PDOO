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
    
    public GestionInmobiliaria(OperacionInmobiliaria gest, int indice){
        this.gestion = gest;
        this.indicePropiedad = indice;
    }
    
    public int getIndicePropiedad(){
        return indicePropiedad;
    }
    
    public OperacionInmobiliaria getOperacion(){
        return gestion;
    }
    
}
