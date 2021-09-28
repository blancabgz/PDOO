
import ejercicios.Parcela;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blanca
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parcela p1 = new Parcela("monte negro", 1000f, 2000f,400f);
      
        for(int i = 0; i < 1; i++){
            p1.construirCasa();
            p1.construirHoteles();
        }
        
        float precioAlquiler = p1.getPrecioAlquilerCompleto();
        
        Parcela p3;
        Parcela p2 = p3 = new Parcela("monte negro", 1000f, 2000f,400f);
        
        Parcela p4 = new Parcela("bosque verde", 1000f, 2000f,400f);
       
        
        System.out.println("El precio completo del alquiler de la parcela " + p1.getNombre() + " es " + precioAlquiler);
        
        if(p1.igualdadEstado(p3)){
            System.out.println("La parcela P1 y P3 tienen el mismo estado");
        }else{
            System.out.println("La parcela P1 y P3 no tienen el mismo estado");
        }
        
        if(p1.igualdadIdentidad(p3)){
            System.out.println("La parcela P1 y P3 tienen la misma identidad");
        }else{
            System.out.println("La parcela P1 y P3 no tienen la misma identidad");
        }
        
        if(p2.igualdadEstado(p3)){
            System.out.println("La parcela P2 y P3 tienen el mismo estado");
        }else{
            System.out.println("La parcela P2 y P3 no tienen el mismo estado");
        }
        
        if(p2.igualdadIdentidad(p3)){
            System.out.println("La parcela P2 y P3 tienen la misma identidad");
        }else{
            System.out.println("La parcela P2 y P3 no tienen la misma identidad");
        }
        
        if(p4.igualdadEstado(p3)){
            System.out.println("La parcela P4 y P3 tienen el mismo estado");
        }else{
            System.out.println("La parcela P4 y P3 no tienen el mismo estado");
        }
        
        if(p4.igualdadIdentidad(p3)){
            System.out.println("La parcela P4 y P3 tienen la misma identidad");
        }else{
            System.out.println("La parcela P45 y P3 no tienen la misma identidad");
        }
        
        
        
    }
    
}
