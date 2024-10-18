package autonoma.models;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */
public class MedicamentoGenerico extends Medicamento {

//    METODOS     
    public MedicamentoGenerico(String nombre, String descripcion, double costo, double precioVenta, Enfermedad enfermedadObjetivo) {    
        super(nombre, descripcion, costo, precioVenta, enfermedadObjetivo);
    }

//    METODOS ABSTRACTOS
    @Override
    public double calcularPrecioVenta() {
        return this.costo * 1.10;  // Precio de venta = costo + 10%
    }
}
