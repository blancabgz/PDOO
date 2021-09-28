/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

/**
 *
 * @author Blanca
 */
public class ParcelaModificado {
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    public static float factoralquilercalle = 1.0f;
    public static float factoralquilercasa = 1.0f;
    public static float factoralquilerhotel = 4.0f;
    
    
    public ParcelaModificado(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        
        this.numCasas = 0;
        this.numHoteles = 0;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public float getPrecioCompra(){
        return precioCompra;
    }
    
    public int getNumCasas(){
        return numCasas;
    }
    
    public int getNumHoteles(){
        return numHoteles;
    }
    
    public float getPrecioAlquilerCompleto(){
        float precio_alquiler = precioBaseAlquiler * (factoralquilercasa + numCasas + (factoralquilerhotel*numHoteles));
        return precio_alquiler;
    }
    
    public boolean construirCasa(){
        numCasas++; 
        return true;
    }
    
    public boolean construirHoteles(){
        numHoteles++; 
        return true;
    }
    
    public boolean igualdadIdentidad(ParcelaModificado otraParcela){
        if (otraParcela == this) {
            return true;
        }
        return false;
    }
    
    public boolean igualdadEstado(ParcelaModificado otraParcela){
        if((this.nombre.equals(otraParcela.nombre))){
                return true;
        }
               
        return false;
    }
    
}
