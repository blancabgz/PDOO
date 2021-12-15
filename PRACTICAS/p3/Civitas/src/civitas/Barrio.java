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
public class Barrio {
    private TipoBarrio tipo;
    private String nombre;
    private float porcentajeEco;
    
    public Barrio(String nombre, TipoBarrio tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
}
