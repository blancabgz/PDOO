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
public class Casilla {
    private TipoCasilla tipo;
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    public static float factoralquilercalle = 1.0f;
    public static float factoralquilercasa = 1.0f;
    public static float factoralquilerhotel = 4.0f;
    
    public Casilla (TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        this.tipo = unTipo;
        this.nombre = unNombre;
        
        this.precioCompra = unPrecioCompra;
        this.precioEdificar = unPrecioEdificar;
        this.precioBaseAlquiler = unPrecioAlquilerBase;
        
        this.numCasas = 0;
        this.numHoteles = 0;
    }
    
    public TipoCasilla getTipo(){
        return this.tipo;
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
    
    public String toString() {
        return " Calle " + nombre + ". \n " + "Precios: " + precioCompra + "\n Edificar " + precioEdificar + "\n Alquiler base: " + precioBaseAlquiler 
                + "\n Casas: " + numCasas + "\n Hoteles: " + numHoteles + "";
    } 
    
}
