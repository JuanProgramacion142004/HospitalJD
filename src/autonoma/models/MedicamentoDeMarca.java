package autonoma.models;

/**
 *
 * @author theBL
 */
public class MedicamentoDeMarca extends Medicamento {
//    ATRIBUTOS

    private String fabricante;

//    METODOS DE ACCESO
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

//    METODOS 

    public MedicamentoDeMarca(String fabricante, String nombre, String descripcion, double costo, double precioVenta, Enfermedad enfermedadObjetivo) {
        super(nombre, descripcion, costo, precioVenta, enfermedadObjetivo);
        this.fabricante = fabricante;
    }
    

//    METODOS ABSTRACTOS
    @Override
    public double calcularPrecioVenta() {
        return this.costo * 1.25;  // Precio de venta = costo + 25%
    }
}
