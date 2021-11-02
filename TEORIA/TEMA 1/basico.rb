module Basico
  class Perro
    @@contador = 0
    attr_accessor :nombre

    def initialize(nombre)
      @@contador += 1
      #inicializo las variable
      self.nombre = nombre
      @id = @@contador
    end

    def getId()
      puts @id
    end

    def nombre=(n)
      if(n != "Perro")
        @nombre = n
      end
    end

  end

  p1 = Perro.new("Perro 1")
  p2 = Perro.new("Perro 2")

  p1.getId()
  p2.getId()
end

