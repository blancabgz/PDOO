class ParcelaModificada
  @factoralquilercalle = 1.0
  @factoralquilercasa = 1.0
  @factoralquilerhotel = 4.0

  def initialize (nombre,precioCompra,precioEdificar, precioBaseAlquiler)
    @nombre = nombre
    @precioCompra = precioCompra
    @precioEdificar = precioEdificar
    @precioBaseAlquiler = precioBaseAlquiler
    @numCasas = 0
    @numHoteles = 0
  end

  attr_reader :nombre, :precioCompra, :precioEdificar, :numCasas, :numHoteles

  def self.calcularPrecioCompleto(precioBase, nCasas, nHoteles)
    precioBase*(@factoralquilercalle * ( @factoralquilercasa + nCasas + (@factoralquilerhotel*nHoteles)))
  end

  def getPrecioAlquilerCompleto
    self.class.calcularPrecioCompleto(@precioBaseAlquiler, @numCasas, @numHoteles)
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

p = ParcelaModificada.new("monte negro",1000,2000,400)
x = 0

p.construirCasa
p.construirHoteles

@precioalquiler = p.getPrecioAlquilerCompleto

puts "El precio del alquiler completo de la parcela #{p.nombre} es #{@precioalquiler}"