from abc import ABC, abstractmethod


class CalculadoraImpuesto(ABC):
    """Interfaz: define el contrato que toda calculadora de impuestos debe cumplir."""

    @abstractmethod
    def calcular(self, monto):
        pass


class ImpuestoIVA(CalculadoraImpuesto):
    """Calcula el impuesto IVA (19%)."""
    def calcular(self, monto):
        return monto * 0.19


class ImpuestoRetencion(CalculadoraImpuesto):
    """Calcula la retención en la fuente (2.5%)."""
    def calcular(self, monto):
        return monto * 0.025
    
class FacturaError(Exception):
    """Excepción base para todos los errores relacionados con facturas."""
    pass


class MontoInvalidoError(FacturaError):
    """Se lanza cuando el monto de la factura es inválido (negativo o cero)."""
    def __init__(self, monto):
        self.monto = monto
        mensaje = f"Monto inválido: {monto}. El monto debe ser mayor a 0."
        super().__init__(mensaje)


class DescuentoInvalidoError(FacturaError):
    """Se lanza cuando el porcentaje de descuento está fuera de rango."""
    def __init__(self, porcentaje):
        self.porcentaje = porcentaje
        mensaje = f"Descuento inválido: {porcentaje}%. Debe estar entre 0 y 100."
        super().__init__(mensaje)


class ClienteInvalidoError(FacturaError):
    """Se lanza cuando el nombre del cliente está vacío o es inválido."""
    def __init__(self, cliente):
        self.cliente = cliente
        mensaje = f"Cliente inválido: '{cliente}'. El nombre no puede estar vacío."
        super().__init__(mensaje)

class Factura:
    def __init__(self, numero, monto, cliente, calculadora_impuesto: CalculadoraImpuesto):
        if monto <= 0:
            raise MontoInvalidoError(monto)
        if not cliente or cliente.strip() == "":
            raise ClienteInvalidoError(cliente)

        self.numero = numero
        self.monto = monto
        self.cliente = cliente
        self.calculadora_impuesto = calculadora_impuesto  # depende de la interfaz, no de una clase concreta

    def aplicar_descuento(self, porcentaje):
        if porcentaje < 0 or porcentaje > 100:
            raise DescuentoInvalidoError(porcentaje)
        descuento = self.monto * (porcentaje / 100)
        self.monto -= descuento
        return self.monto

    def calcular_total_con_impuesto(self):
        impuesto = self.calculadora_impuesto.calcular(self.monto)
        return self.monto + impuesto

    def __str__(self):
        return f"Factura #{self.numero} - Cliente: {self.cliente} - Monto: ${self.monto:.2f}"


# Pruebas — evidencia de ejecución
factura_iva = Factura(1003, 500000, "Carlos Ruiz", ImpuestoIVA())
print(factura_iva)
print(f"Total con IVA: ${factura_iva.calcular_total_con_impuesto():.2f}")

factura_retencion = Factura(1004, 500000, "Laura Gómez", ImpuestoRetencion())
print(f"Total con retención: ${factura_retencion.calcular_total_con_impuesto():.2f}")

# Pruebas — evidencia de ejecución para tu entrega
try:
    factura_mala = Factura(numero=1002, monto=-100, cliente="Ana",calculadora_impuesto=ImpuestoIVA())
except MontoInvalidoError as e:
    print(f"Error capturado: {e}")

try:
    factura1 = Factura(numero=1001, monto=500000, cliente="Juan Pérez", calculadora_impuesto=ImpuestoIVA())
    factura1.aplicar_descuento(150)
except DescuentoInvalidoError as e:
    print(f"Error capturado: {e}")