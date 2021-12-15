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
public class Hacienda {
    static final private Hacienda instance = new Hacienda();
    private float caja;
    
    static public Hacienda getInstance() {
        return instance;
    }
    
    public void combraImpuestoECO(float importe, boolean esAlquiler, Barrio barrio){
        
    }
}
