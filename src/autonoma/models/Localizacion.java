package autonoma.models;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/17/2024
 * @version 1.0.0
 */
public class Localizacion {

    // ATRIBUTOS
    private double latitud;
    private double longitud;

    // METODOS DE ACCESO
    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    // METODOS
    public Localizacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Localización [Latitud: " + latitud + ", Longitud: " + longitud + "]";
    }
}
