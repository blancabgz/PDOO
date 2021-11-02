# Sesión 6: Diagramas Estructurales

Existen diferentes tipos de diagramas.

## DIAGRAMA DE CLASES

Muestra las clases y sus relaciones. Entre los tipos de relaciones están:

* Asociación
* Dependencia
* Generalización
* Realización

Recordamos como hemos visto temas atrás la **simbología**:

* **-**: privado
* **<u>subrayado</u>**: de clase
* **+**: público
* **~**: de paquete
* **#**: protegido

Además podemos indicar tanto el valor inferior como el superior de un array y los valores por defecto de algunos atributos.

### RELACIÓN DE ASOCIACIÓN

![image-20211030190302683](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211030190302683.png)

* **Bidireccional:** va en ambos sentidos
* **Unidireccional:** se restringe la navegación en el sentido de la flecha
* **Agregación:** Una de las clases depende de otra pero cuando no está relleno, es débil. En esta relación se trata como una bidireccional hasta que no demos herencia. 
* **Composición:** una clase no puede existir sin otra.

En el ejemplo de la Figura se puede leer la asociación como “Una escuela está ubicada en una dirección”.

![UML: Relaciones entre Clases - UmainClass](https://3.bp.blogspot.com/-wHIDfCL_bgs/WEundVkB6qI/AAAAAAAAANk/10Ta69WE77oaShWagQJLg5lNKwi8C7NKwCLcB/s1600/asociacion.png)

Se puede añadir **multiplicidad** a las relaciones:

* **1:** Uno
* **0...1:** Cero o un objeto
* **N...M:** muchos
* *****: Cero o varios
* **0...***: Cero o varios
* **1...***: Uno o varios (al menos uno)

![image-20211030191811270](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211030191811270.png)



### RELACIÓN DE DEPENDENCIA

![image-20211030190635827](C:\Users\Blanca\Desktop\UNIVERSIDAD 21-22\PDOO\TEORIA\TEMARIO_EXAMEN\image-20211030190635827.png)

Significa que existe una **relación débil y poco duradera**. Se utiliza cuando desde una clase se utilizan instancias de otra clase. Esta relación no genera atributos (¡Cuidado que NO genera atributos de dependencia!)

<img src="C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211030190913172.png" alt="image-20211030190913172" style="zoom: 50%;" />

## DIAGRAMA DE PAQUETES

Permite expresar las relaciones de dependencia entre paquetes. 

![image-20211030191450960](C:\Users\Blanca\AppData\Roaming\Typora\typora-user-images\image-20211030191450960.png)

