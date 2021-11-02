module Controlador_laberinto
  require_relative "../modelo_laberinto/habitacion.rb"
  require_relative "../modelo_laberinto/laberinto.rb"
  require_relative "Estado_juego.rb"

  class Controlador
    def initialize
      @vidas = 0
      @estado = Estado_juego.new()
      @modelo = Laberinto.new()
      @habitacion_usuario = Habitacion.new()
    end
  end
end
