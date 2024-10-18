package autonoma.models;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */
public abstract class Persona {
//    ATRIBUTOS

    private String nombre;
    private String numeroDocumento;
    private int edad;

//    METODOS DE ACCESO
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

//    METODOS
    public Persona(String nombre, String numeroDocumento, int edad) {
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.edad = edad;
    }

//    METODOS ABSTRACTOS --GERENTE-- --PACIENTE-- --EMPLEADO--
    public abstract String obtenerTipoPersona();

}
