require_relative "../controlador_laberinto/controlador.rb"


class Vista_laberinto
    attr_reader :controlador
    def initialize (controlador)
        @controlador = Controlador.new()
    end

    def menu_usuario
        while (@controlador.estado != Controlador_laberinto::Estado_juego::EN_SALIDA_LABERINTO && @controlador.estado != Controlador_laberinto::Estado_juego::DENTRO_MUERTO)
            if (@controlador.estado == Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO)
                vida_inicio = gets
                while(vida_inicio < 0 || vida_inicio > 10)
                    vida_inicio = gets
                end
                @controlado.entrar(vida_inicio)

            elsif (@controlador.estado == Controlador_laberinto::Estado_juego::DENTRO_VIVO)
                puts informe_dentro(@controlador.habitacion_usuario,vida_inicio)
                enter = gets
                while(enter != "\n")
                    enter = gets
                end
                direccion = @controlador.intentar_avanzar

            elsif (@controlador.estado == Controlador_laberinto::Estado_juego::EN_SALIDA_LABERINTO && @controlador.estado == Controlador_laberinto::Estado_juego::DENTRO_MUERTO)
                puts informe_final(vida_inicio)
                exit 0
            end
        end
    end


    def informe_dentro(habitacion, vidas)
        inf = "Esta en la habitacion " + habitacion + " y el numero de vidas es " + vidas
    end

    def informe_final(vidas)
        inf = "El numero final de vidas es " + vidas
    end

end