package autonoma.models;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */
public abstract class Empleado extends Persona {

//    ATRIBUTOS
    
    private double salarioBase;


//    METODOS DE ACCESO
    
        public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

//    METODOS
    
    public Empleado(double salarioBase, String nombre, String numeroDocumento, int edad) {
        super(nombre, numeroDocumento, edad);
        this.salarioBase = salarioBase;
    }
    
//    METODOS ABSTRACTOS
    
    public abstract double calcularSalario();
    
    @Override
    public String obtenerTipoPersona(){
        return "EMPLEADO";
    }
    

}
