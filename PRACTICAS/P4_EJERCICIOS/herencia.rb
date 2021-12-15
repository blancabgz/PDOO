module Herencia
  class Persona
    def initialize(nombre)
      @nombre = nombre
    end

    def andar
      result = "Soy #{@nombre} y estoy andando"
    end

    def to_s
      result = "Soy una persona y mi nombre es #{@nombre}"
    end

  end

  class Deportista < Persona
    def initialize(nombre,horas)
      super(nombre)
      @horas_entrenamiento = horas
    end

    def competicion_deportiva
      result = "Soy #{@nombre} y participo en competiciones"
    end
  end

  class Corredor < Deportista
    def correr
      result =  "#{@nombre} corre"
    end

    def to_s
      result = super + " y soy corredor"
    end
  end

  class Nadador < Deportista
    def nadar
      result = " #{@nombre} nada"
    end

    def to_s
      result = super + " y soy nadador"
    end
  end

  persona = Persona.new("Juan")
  puts persona.andar

  deportista = Deportista.new("alberto",22)
  # andar lo hereda de persona
  puts deportista.andar
  #Lo hereda de persona
  puts deportista.to_s
  # Aplica su propio metodo dentro de su clase
  puts deportista.competicion_deportiva

  # constructor de deportista
  corredor = Corredor.new("Maria", 22)
  # andar hereda de persona
  puts corredor.andar
  # to string lo hereda de persona
  puts corredor.to_s
  # competicion_deportiva lo hereda de deportista
  puts corredor.competicion_deportiva
  # correr es un metodo de su propia clase
  puts corredor.correr

  # constructor de deportista
  nadador = Nadador.new("Blanca",23)
  # andar hereda de persona
  puts nadador.andar
  # to string lo hereda de persona
  puts nadador.to_s
  # competicion_deportiva lo hereda de deportista
  puts nadador.competicion_deportiva
  # nadar es un metodo de su propia clase
  puts nadador.nadar
end