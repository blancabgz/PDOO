# Sesión 3: Constructores

Los **constructores** se encargan de la inicialización de las instancias. Es importante **inicializar todos los atributos**. 

## JAVA

Características:

* Tienen el mismo nombre que la clase.
* No devuelven nada (ni void).
* Se utilizan únicamente para asegurar la inicialización de los atributos.
* Puede haber varios que se llamen igual pero tienen que tener diferentes parámetros.
* Se puede reutilizar un constructor desde otro constructor.
* Para construir un objeto se utiliza **new**.
* Existe un constructor por defecto. 

**Ejemplo: **

```java
class Persona {
    private static int numPersonas = 0; // Atributo de clase
    private String nombre; // Atributo de instancia
    private int edad; // Atributo de instancia
    
    Persona(String nombre){ // constructor
        this.nombre = nombre;
    }
    
    Persona(int edad){ // constructor
        this.edad = edad;
    }
    
    Persona (int edad, String nombre){ // constructor que reutiliza
        this (edad);
        this (nombre);
    }
    
    private int devolverEdad(){ // metodo de instancia
        return edad;
    }
    
}
```

## RUBY

Características:

* Llamada a initialize
* Es un método de instancia privado
* Se le llama con new
* Crea e inicializa atributos de instancia
* No se puede sobrecargar

 **EJEMPLO**

```ruby
class Persona
    def initialize (nombre_usuario, edad_usuario)
        @nombre = nombre_usuario 
        @edad = edad_usuario
    end
end
```

