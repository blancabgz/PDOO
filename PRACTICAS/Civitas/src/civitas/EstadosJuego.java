// Conjunto de valores que represente una colección de elementos. Los enum en Java se usan cuando conocemos 
// todos los valores posibles en tiempo de compilación

package civitas;

enum EstadosJuego {
  INICIO_TURNO,
  DESPUES_AVANZAR,
  DESPUES_COMPRAR,
  DESPUES_GESTIONAR
}

enum TipoCasilla {
    CALLE,
    SORPRESA,
    DESCANSO
}

enum TipoSorpresa{
    PAGARCOBRAR,
    PORCASAHOTEL
}
