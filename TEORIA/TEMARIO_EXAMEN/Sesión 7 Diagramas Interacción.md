# Sesión 7: Diagramas de Interacción

Su propósito es **mostrar** el comportamiento del sistema a través de las **interacciones entre los elementos del modelo.**

Hay dos tipos:

* **Diagrama de secuencia**

* **Diagrama de colaboración**

## DIAGRAMA DE SECUENCIA

El **diagrama de secuencia** es un tipo de diagrama de interacción cuyo objetivo es describir el comportamiento del sistema haciendo énfasis en la secuencia de los mensajes intercambiados por los objetos.

Un diagrama tiene dos dimensiones:

* **Eje vertical:** representa el tiempo.
* **Eje horizontal:** representa los diferentes objetos.

En la siguiente imagen podemos identificar que significa cada cosa:

![image-20211030195514180](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211030195514180.png)

Ahora vamos con un ejemplo de diagrama y su implementación en Java y en Ruby.

![image-20211030195744090](C:\Users\Blanca\Desktop\UNIVERSIDAD 21-22\PDOO\TEORIA\TEMARIO_EXAMEN\image-20211030195744090.png)



#### RUBY

```ruby
class Agente
    # ... 
    def dimeTiempo(dia)
        ciudad = posicionActual()
        @meteo.dimeTiempo(ciudad,dia)
    end
     # ... 
end
        
```

#### JAVA

```java
class Agente {
    private SistemaMetereologico meteo;
    
    String timeTiempo(Date dia){
        String ciudad = posicionActual(); // es un método de Agente
        return meteo.dimeTiempo(ciudad, dia); // dimeTiempo es un método dentro de la clase SistemaMetereologico
    }
}
```

Ahora vamos a las partes que nos pueden salir:



### CONDICIONALES

![image-20211030201354377](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211030201354377.png)

El **ALT significa if y la línea discontinua dentro del cuadrado el else**. 

#### RUBY

```ruby
class Agente
    # ...
    def dimeTiempo (dia)
        ciudad = posicionActual() #Llamada al método de la clase Agente
        if ciudad != null
            @meteo.dimeTiempo(ciudad,dia)
        else
           	@meteo.dimeTiempo(ciudadHabitual, dia)
        end
    end
    # ...
end
```

#### JAVA

```java
class Agente {
    private SistemaMetereologico meteo;
    private String ciudadHabitual = "Granada";  // esta info la da sistema de clases
    String dimeTiempo(Date dia){
        String ciudad = posicionActual();
        if(ciudad != null){
            return meteo.dimeTiempo(ciudad, dia);
        }else{
            return meteo.dimeTiempo(ciudadHabitual,dia);
        }
    }
}
```

![image-20211030202314831](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211030202314831.png)

El **opt** significa un **if único**.

#### RUBY

```RUBY
class Agente
    # ...
    def dimeTiempo (dia)
       	diaActual = diaActual() #Llamada al método de la clase Agente
        if (dia.getTime - diaActual.getTime) < 15
            ciudad = posicionActual() #Llamada al método de la clase Agente
        	if ciudad != null
            	@meteo.dimeTiempo(ciudad,dia)
       		else
            	@meteo.dimeTiempo(ciudadHabitual, dia)
        	end
        end
    end
    # ...
end
```

#### JAVA

```java
class Agente {
    private SistemaMetereologico meteo;
    private String ciudadHabitual= "Granada"; // esta informacion la tienes cuando veas el diagrama de clases
    
    String dimeTiempo(Date dia){
        Date diaActual = diaActual();
        if(dia.getTime() - diaActual.getTime() < 15){
           String ciudad = this.posicionActual();
            if(ciudad != null){
            	return meteo.dimeTiempo(ciudad, dia);
        	}else{
            	return meteo.dimeTiempo(ciudadHabitual,dia);
        	}
        }
    }
}
```



### BUCLES

Se identifica con la caja **loop**, todo lo que haya dentro de esa caja, entra en el bucle.

![image-20211031102419028](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211031102419028.png)

#### RUBY

```ruby
class Agente
    def dimeTiempo(fechas)
        tiempo = ""
        for i=0 in fechas do
            dia = i
            tiempoDia = dimeTiempo(dia)
       		tiempo = tiempo + tiempoDia  
        end
     return tiempo
end
```

#### JAVA

```java
class Agente {
    String dimeTiempo(ArrayList<Date> fechas){
        String tiempoDia;
        Date dia;
        String tiempo = "";
        
        for(int i = 0; i < fechas.size(); i++){
            dia = fechas.get(i);
            tiempoDia = dimeTiempo(dia);
            tiempo += tiempoDia;
        }
        
        return tiempo;
    }
}
```



### CREACIÓN DE INSTANCIAS

Aparece como un objeto de otra clase a crear.

![image-20211031111942190](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211031111942190.png)

#### RUBY

```ruby
class Restaurante
    @reservas = Array.new
    def reservar(hora,comensales,id)
        disponible = comprobarDisponibilidad(hora,comensales)
        if disponible
            re = Reserva.new(hora, comensales, id)
            @reservas << re
        end
    end
end
            
```

#### JAVA

```JAVA
class Restaurante {
    private ArrayList<Reserva> reservas = new ArrayList();
    
    void reservar(int hora, int comensales, int id){
        Boolean disponible = comprobarDisponibilidad(hora,comensales);
        Reserva re;
        if(disponible){
            re = new Reserva(hora, comensales,id);
            reservas.add(re);
        } 
    }
}
```

### RECURSIVIDAD

![image-20211031112742946](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211031112742946.png)

#### RUBY

```RUBY
class Contenedor
    def indicarContenido
        salida  = salida + getNombre()
        salida  = salida + indicarContenido()
    end
end
```

## DIAGRAMAS DE COMUNICACIÓN

Se representan mediante líneas que unen a los participantes.

Los **tipos de enlaces** que hay son:

* **GLOBALES (G):** uno de los participantes pertenece a un ámbito superior como por ejemplo un atributo de clase.
* **ASOCIACIÓN (A):** entre los participantes hay una asociación.
* **PARÁMETRO (P):** uno de los objetos es pasado como parámetro a un método del otro participante.
* **LOCAL (L):** uno de los participantes es un objeto local a un método del otro participante.
* **SELF(S):** un objeto también puede enviarse mensajes a sí mismo.



![image-20211031125335438](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211031125335438.png)

#### RUBY

```ruby
class Controlador
    def llevarDronA(punto)
        dron = dronMasCercano(punto)
        dron.navegar(punto)
```

#### JAVA

```java
class Controlador{
	public float llevarDronA(Lugar punto){
        Dron dron = dronMasCercano(punto);
        dron.navegar(punto);
    }
}
```



![image-20211031125849400](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211031125849400.png)

#### RUBY

```ruby
class Controlador
    def initialize
        @aparatos = Aparatos.new()
    end
    def alturaDron(id)
        dron = @aparatos.getDron(id)
        altura = dron.getAltura()
        return altura
    end
end
```

#### JAVA

```java
class Controlador {
    ArrayList<Dron> aparatos = new ArrayList<Dron>();
    public float alturaDron(int id){
        Dron dron = aparatos.getDron(id);
        float altura = dron.getAltura();
        return altura;
    }
}
```

![image-20211031161146207](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211031161146207.png)

Si te fijas, en el método pone incluir pero la cajetilla donde va aparatos es doble, así que no hay ningun método que se llame incluir, quiere decir que lo metas en el array de aparatos.

#### RUBY

```RUBY
class Controlador
    
    def initialize
        @aparatos = Aparatos.new()
    end
    
    def incluirNuevoDron(dron,lugar)
        dron.navegar(lugar)
        @aparatos << dron
    end
end
```

#### JAVA

```java
class Controlador {
    ArrayList<Dron> aparatos = new ArrayList();
    
    public void incluirNuevoDron(Dron dron, Lugar lugar){
        dron.navegar(lugar);
        aparatos.add(dron);
    }
}
```



![image-20211031161650596](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211031161650596.png)

#### RUBY

```ruby
class Controlador
    def aterrizarDronesBajoAltura(alt)
        #primero pide un for *[paratodos] y siguiente es coger el dron
        for i = 0 in aparatos do
            dron = i
            altura = dron.getAltura()
            #pide un if 
            if altura <= alt
                dron.aterrizar()
            end
        end
    end
end
```

#### JAVA

```java
class Controlador {
    public void aterrizarDronesBajoAltura(float alt){
        Dron dron;
        float altura;
        
        for(int i = 0; i < aparatos.size(); i++){
            dron = aparatos.get(i);
            altura = dron.getAltura();
            if(altura <= alt){
                dron.aterrizar()
            }
        }
    }
}
```

