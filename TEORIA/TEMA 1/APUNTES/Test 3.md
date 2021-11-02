

# Clase 3

## TEST

### Ejercicio 1

Cuando el rombo está coloreado, hay que tener cuidado en el sistema al borrar un objeto Banco, borramos también las cuentas bancarias.

### Ejercicio 2

El banco tiene 4 atributos.

### Ejercicio 3

Cuando las flechas están punteadas es una relación de dependencia, de forma que nos indica solamente que se va a utilizar. No es una relación tan fuerte como la relación de asociación.

### Ejercicio 4

Las restricciones se suelen indicar entre llaves y son propiedades que aparecen en los diagramas y se tienen que tener en cuenta más adelante, cuando se implementan los métodos. Por ejemplo, si un equipo tiene un capitán, hay que controlar que solo sea uno, al igual que si un equipo tiene 1 o más jugadores, hay que controlar eso.

### Ejercicio 5

Tienes que hacer toda la ruta para indicar un paquete. Si pones un import de B.* es que haces un import del paquete completo. 

### Ejercicio 6

(Completar apuntes)



## Ejercicio de clase

![image-20211005100955522](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211005100955522.png)

En la clase Pabellón, vemos que en capacidadTotal hay un \, esto nos indica que se trata de un atributo calculado. 

### CLASE RESERVA

EVENTO -- 1 --- 1 ..* -- RESERVA -- 1..* --- 1 --- SALA

```ruby
class Reserva
	def initialize (evento, fecha, sala)
		@fecha = fecha
		@evento = evento
		@sala = sala
	end
end
```

### CLASE SALA

```java
class Sala {
	private int idSala;
	private int capacidad;
	private String nombre;
	
	public Boolean reservar(Evento.evento,Date fecha){}
	private Boolean estaLibre(Date fecha){}
}
```



![image-20211005104059380](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211005104059380.png)

```java
class Barco {
	private String nombre = "maldito";
    private ArrayList<Pirata> tripulacion;
    private Pirata capitan;
    private ArrayList<Isla> atracaderos;
    private ArrayList<Posicion> mapasTesoro;
    private sietemares.Posicion posicionActual;
}
```

