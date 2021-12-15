# CLASES ABSTRACTAS

![image-20211123094201447](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211123094201447.png)



Las clases abstractas son clases que se declaran con todos sus atributos y métodos pero tendrán al menos un método sin implementar. 

No se puede crear objetos de la clase figura geométrica porque llamo a métodos que no tienen código (métodos abstractos). 

Para las subclases si el obligatorio implementar los métodos y si no lo hiciera, ella sería abstracta y sus subclases deberían implementarlo. 

La gracia de crear la clase Figura Geométrica, te crea una estructura común pero el comportamiento específicos se implementa a parte.

```java
abstract class FiguraGeometrica {
	public abstract float area(); // solo se le pone la cabecera
}

class Circulo extends FiguraGeometrica{
	@Override
	public abstract float area(){
		// calculo del area
	}
}
```

Ruby no soporta las clases abstractas entonces si queremos hacer algo parecido lo tendríamos que hacer es:

* Crear una clase de la que no se genera instancias --> constructor privado

* Métodos los ponemos públicos

![image-20211123095210728](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211123095210728.png)

![image-20211123095219113](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211123095219113.png)

Aquí podemos ver que el método transportar de la clase Tren, también es abstracto, además de ser abstracta la clase MedioTransporte.

# INTERFACES

Nos va a indicar una serie de métodos y la clase que implementa esa interfaz, se compromete a implementar dichos métodos. 

![image-20211123095356232](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211123095356232.png)

Se puede poner con <<Interface>> o con un círculo. La clase pájaro implementa la interfaz volador y en Volador es abstracto. 

En Ruby no existe.



# TEST

* Si habitación es una clase abstracta de la que hereda Dormitorio, ¿cual de las siguientes creaciones de objetos es errónea?
  * Habitacion habitacion = new Habitacion();  **ESTA** debido a que es una clase abstracta y no puedo crear objetos de esta clase habitación.
  * Habitacion habitacion = new Dormitorio(); 
  * Dormitorio dormitorio = new Dormitorio();
* ¿Que métodos son abstractos del diagrama de la dispositiva 11?
  * Vivir y transportar
* ¿El método compareTo() de la interfaz Comparable de Java...?
  * Es un método abstracto. 

# EJERCICIO CLASE

![image-20211123102348458](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211123102348458.png)

**CLASES ABSTRACTAS**

BienGeneradoInteres con el método adquirir() que viene en cursiva.  

BienInmueble es una clase abstracta porque una subclase suya lo implementa. 

**INTERFACES**

Canjeable con el método canjear en cursiva abstracto.



```java
public abstract class BienGeneradorIntereses{
    public void generarIntereses(){
        System.out.printl("Genero intereses");
    }
    
    public abstract void adquirir();
}

public abstract class BienInmueble extends BienGeneradorIntereses{
   	protected float valorActual;
    
    public void vender(){
        System.out.printl("Vendo");
    }
}

public class Propiedad extends BienInmueble{
    private float cantidad;
    @Override
    public void adquirir(){
        System.out.printl("Adquiero");
    }
    
    public void incrementar(float cant, int tiempo){
        cantidad += cant;
        System.out.printl("Incremento");
    }
}

public interface Canjeable{
    public abstract void canjear(float cant);
}

public class Bono extends Deposito implements Canjeable{
    @Override
    public void canjear(float cant){
        System.out.println("Canjeo");
    }
}
```

## PREGUNTAS

```java
// Fallo: es una clase abstracta y no la puedes referenciar (ERROR COMPILACION)
BienGeneradorIntereses b  = new BienGeneradorIntereses();
// CORRECTO
Deposito d = new Accion();
// CORRECTO
d.adquirir();
// NO FUNCIONA POR LOS ARGUMENTOS
d.incrementar();
// FALLA EN COMPILACION PORQUE TIENE DOS ARGUMENTOS
d.incrementar(32); 
// CORRECTO
((Accion).d).incrementar(32);
// correcto
d = new Bono();
// Error en tiempo de compilacion -> porque se va a deposito y dice no ta
d.canjear(2);
// CORRECTO
((Bono).d).canjear(2);
```

