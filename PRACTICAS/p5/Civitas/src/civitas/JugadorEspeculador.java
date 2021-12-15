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
public class JugadorEspeculador extends Jugador{
    private static final int factorEspeculador = 2;
    private static final float factorPago = (float) -0.5;

    protected JugadorEspeculador(Jugador j) {
        super(j);
        for(int i = 0; i < super.getPropiedades().size(); i++){
            j.getPropiedades().get(i).actualizaPropietarioPorConversion(j);
        }
    }
    
    // Metódo que modifica el saldo del jugador cuando paga
    @Override
    boolean paga(float cant){
        float saldo = cant * factorPago;
        return this.modificaSaldo(saldo);
    }
    
    @Override
    int getCasasMax(){
        return super.getCasasMax() * factorEspeculador;
    }
    
    int getHotelesMax(){
        return super.getHotelesMax()* factorEspeculador;
    }
    @Override
    public boolean soyEspeculador(){
        return true;
    }
    
    @Override
    public String toString(){
        return "" + this.getNombre() + " es un jugador especulador y tiene " + this.cantidadCasasHoteles() + " propiedades y se encuentra en la casilla " + this.getCasillaActual();
    }
    
    
    
    
    
   
}
