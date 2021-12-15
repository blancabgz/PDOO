# EJERCICIOS CLASE 

## JAVA

```JAVA
class Persona{
    private String nombre;
    private int edad;
    private Mascota mascota;
    
    public class Persona(String nombre, int edad, Mascota mascota){
        this.nombre = nombre;
        this.edad = edad;
        this.mascota = mascota;
    }
}

class Mascota{
    private int id;
    
    public class Mascota(int id){
        this.id = id;
    }
}
```

## MAIN

```java
Mascota m1 = new Mascota(1);
Persona p = new Persona ("Fulano",13,m1);
Persona p2 = p1;
```

## HACER UNA REPLICA

1. Generar clones con el método clone.
2. Generar con un constructor de copia (superficial). 

## CONSTRUCTOR POR COPIA (SUPERFICIAL)

```java
class Persona{
    private String nombre;
    private int edad;
    private Mascota mascota;
    
    public Persona(String nombre, int edad, Mascota mascota){
        this.nombre = nombre;
        this.edad = edad;
        this.mascota = mascota;
    }
    
    // constructor de copia
    public Persona (Persona p){
        this.nombre = p.nombre;
        this.edad = p.edad;
        this.mascota = mascota;
    }
}

class Mascota{
    private int id;
    
    public class Mascota(int id){
        this.id = id;
    }
}
```

## MAIN

```java
Mascota m1 = new Mascota(1);
Persona p = new Persona ("Fulano",13,m1);
Persona p2 = new Persona(p1);
```

El problema aquí es que comparten el gato. Si queremos hacer una copia completa, tenemos que hacer una copia profunda. 

## CONSTRUCTOR DE COPIA PARA MASCOTA PARA HACER PROFUNDA

```JAVA
class Persona{
    private String nombre;
    private int edad;
    private Mascota mascota;
    
    public Persona(String nombre, int edad, Mascota mascota){
        this.nombre = nombre;
        this.edad = edad;
        this.mascota = mascota;
    }
    
    // constructor de copia
    public Persona (Persona p){
        this.nombre = p.nombre;
        this.edad = p.edad;
        this.mascota = new Mascota(original.mascota);
    }
}

class Mascota{
    private int id;
    
    public Mascota(int id){
        this.id = id;
    }
    
    public Mascota (Mascota m){
        this.id = m.id;
    }
}
```

## METODO CLONE

```java
class Persona implements Cloneable{
    private String nombre;
    private int edad;
    private Mascota mascota;
    
    public class Persona(String nombre, int edad, Mascota mascota){
        this.nombre = nombre;
        this.edad = edad;
        this.mascota = mascota;
    }
    
    public Persona clone() throws CloneNotSupportedException {
        return (Persona) super.clone();
    }
}

class Mascota{
    private int id;
    
    public class Mascota(int id){
        this.id = id;
    }
}
```

```java
Mascota m1 = new Mascota(1);
Persona p = new Persona ("Fulano",13,m1);
try{
    Mascota m2 = (Mascota) m1.clone();
} catch(CloneNotSupportedException ex){
    System.err.printl("Clone not supported");
}

Persona p2 = (Persona) p1.clone();
```

