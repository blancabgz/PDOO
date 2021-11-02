class Parcela

  @@factoralquilercalle = 1.0
  @@factoralquilercasa = 1.0
  @@factoralquilerhotel = 4.0

  def initialize (nombre,precioCompra,precioEdificar, precioBaseAlquiler)
    @nombre = nombre
    @precioCompra = precioCompra
    @precioEdificar = precioEdificar
    @precioBaseAlquiler = precioBaseAlquiler
    @numCasas = 0
    @numHoteles = 0
  end

  attr_reader :nombre, :precioCompra, :precioEdificar, :numCasas, :numHoteles

  def getPrecioAlquilerCompleto
    @precioBaseAlquiler*(@@factoralquilercalle * (@@factoralquilercasa+@numCasas+(@@factoralquilerhotel*@numHoteles)))
  end

  def construirCasa
    @numCasas+=1
    @true
  end

  def construirHoteles
    @numHoteles+=1
    @true
  end
end

p = Parcela.new("monte negro",1000,2000,400)

x = 0

p.construirCasa
p.construirHoteles


@precioalquiler = p.getPrecioAlquilerCompleto

puts "El precio del alquiler completo de la parcela #{p.nombre} es #{@precioalquiler}"

