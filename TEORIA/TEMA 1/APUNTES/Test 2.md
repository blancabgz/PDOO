# Test

## Ejercicio 1

En Ruby, se pueden utilizar métodos consultores dentro de clases dependiendo del orden en que se inicialicen los atributos.

```ruby
class Persona {
	String nombre;
	String apellidos;
	String nombre_completo;
}

```

### Solución 1:  no está mal pero podría ser mejor

```ruby
    
Persona (String n, String a){ 
   nombre = n;
   apellidos = a; 
   nombre_completo = a + n;
}
```

### Solución 2: no es una solución muy acertada porque n y a pueden cambiar

```ruby
Persona (String n, String a){
   setNombre(n);
   setApellidos(a);
   nombre_completo = n + " " + a;	
}
```

### Solución 3: esta solución es muy válida

```ruby
Persona (String n, String a){
   setNombre(n);
   setApellidos(a);
   nombre_completo = getNombre() + " " + getApellidos();	
}
```

Solución 4: 

```ruby
Persona (String n, String a){
   setNombre(n);
   setApellidos(a);
   nombre_completo = nombre + " " + apellidos;	
}
```



## Ejercicio 2

Se puede hacer this.setNombre(n) dentro de un constructor.



## Ejercicio 3

No hace falta crear un método de modificador exclusivamente para realizar una comprobación, por lo que se utiliza attr_accesor + comprobación.

## Ejercicio 4

En el código: 

```java
p1 = new Persona("Luis");
p2 = p1;
p3 = p2;
```

Como tal hay un objeto porque solo hay un new, p2 y p3 son variables apuntando al mismo objeto. Por lo que si en p2 cambio algo del objeto, afecta a p1 y p3 porque es el mismo objeto.



## 