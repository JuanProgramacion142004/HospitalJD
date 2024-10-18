package autonoma.models;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 2.0.1
 */
public class Gerente extends Persona {

//    ATRIBUTOS
    private String carrera;

    
//    METODOS DE ACCESO


    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

//    METODOS

    public Gerente(String nombre, String numeroDocumento, int edad, String carrera) {
        super(nombre, numeroDocumento, edad);
        this.carrera = carrera;
    }

    

    public void actualizarGerente(String nombre, String numeroDocumento, int edad, String carrera){
        setNombre(nombre);
        setNumeroDocumento(numeroDocumento);
        setEdad(edad);
        this.carrera = carrera;
    }
    
    @Override
    public String obtenerTipoPersona(){
        return "GERENTE";
    }
    
}
