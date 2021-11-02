# CLASE 26/10/2021

## DIAGRAMA DE COMUNICACIÓN Y CLASES



<img src="C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211026094134406.png" alt="image-20211026094134406" style="zoom:100%;" />

![DC - Piratas](C:\Users\Blanca\Desktop\UNIVERSIDAD 21-22\PDOO\TEORIA\TEMA 1\DC - Piratas.jpg)

### Clase barco

[ ] es una condición

*[ ] bucle y tengo que decidir si es for o while

```java
class Barco {
	public void repartirTesoro(int monedas){
        Pirata capitan;
        Pirata pirata;
        ArrayList<Pirata> tripulacion;
		//1 Le pido que decida porcentaje y se guarda en p (Capitan) devuelve int porque tienes que mirar la clase Barco, el metodo decidirPorcentaje para ver que devuelve
        int p = capitan.decidirPorcentaje();
        // nota 1: tras el paso 1 hacer, para saber el tipo miro el paso 5 y como ganar(int monedas) se usa, pues es de tipo int
        int monedasCapitan = (monedas * p) / 100;
		//2 El tamaño no tiene porque llamarse tamaño, pero quiero el tamaño de esa colección y depende de la colección
        int numPiratas = tripulación.size();
        //nota 2: 
        int monedasPirata = (monedas - monedasCapitan) / numPiratas;
        //3 va dentro de un bucle for
		//4 va dentro del mismo bucle for que el 3
        for(int i = 0; i < numPiratas; i++){
            pirata = tripulacion.get(i);
            pirata.ganar(monedasPirata);
        }
		//5 fuera del bucle for
        capitan.ganar(monedasCapitan);
	}
}
```

## EJERCICIO 2  CON DIAGRAMA SECUENCIA

```java
class Barco{
    public Posicion posicionActual;
	public void buscarSiguienteTesoro(){
        ArrayList<Posicion> mapasTesoro;
        Barco barco;
        int PRIMERO = 0;
        // paso 1
        Posicion destino = mapasTesoro.get(PRIMERO);
        // paso 2
        this.navegarA(destino);
    }
    
    public void navegarA(Posicion destino){
        boolean enDeuda = false;
        ArrayList<sietemares.Isla> atracaderos;
        Isla isla;
        int PRIMERO = 0;
        
        // paso 1
        int dias = destino.diasDesde(posicionActual);
        while(dias > 0 && !enDeuda){
            if(dias > 1){
                isla = atracaderos.get(PRIMERO);
                
            }
        }
    }
}
```

## EJERCICIO 3 INVENTADO

![image-20211026103446493](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211026103446493.png)



```ruby
class Protectora
   def ayudarMas3Adopciones(ayuda)
       #paso 1: 
       @familias.each{ |p| 
           #paso 2:
           numAnimalesAdoptados = p.numeroAdopciones
           if(numAnimalesAdoptados > 3)
               #paso 3:
               p.recibirAyuda(ayuda)
           end
       }
   end
    
    def numeroAdopciones
        numeroAnimalesAdoptados = 0
        @animales.each{ |a|
            	adoptado = a.esAdoptado
            	if(adoptado)
                    numAnimalesAdoptados++
                end
            }
        return numeroAnimalesAdoptados
    end
end
```

