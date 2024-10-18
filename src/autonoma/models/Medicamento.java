package autonoma.models;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */
public abstract class Medicamento {
//    ATRIBUTOS

    protected String nombre;
    protected String descripcion;
    protected double costo;
    protected double precioVenta;
    protected Enfermedad enfermedadObjetivo;

//    METODOS DE ACCESO
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Enfermedad getEnfermedadObjetivo() {
        return enfermedadObjetivo;
    }

    public void setEnfermedadObjetivo(Enfermedad enfermedadObjetivo) {
        this.enfermedadObjetivo = enfermedadObjetivo;
    }

//    METODOS 
    public Medicamento(String nombre, String descripcion, double costo, double precioVenta, Enfermedad enfermedadObjetivo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precioVenta = precioVenta;
        this.enfermedadObjetivo = enfermedadObjetivo; 
    }

//    METODOS ABSTRACTOS
    public abstract double calcularPrecioVenta();
}
