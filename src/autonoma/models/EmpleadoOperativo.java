package autonoma.models;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */
public class EmpleadoOperativo extends Empleado {
//    ATRIBUTOS

    private String area;

//    METODOS DE ACCESO
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

//    METODOS 
    
    public EmpleadoOperativo(String area, double salarioBase, String nombre, String numeroDocumento, int edad) {
        super(salarioBase, nombre, numeroDocumento, edad);
        this.area = area;
    }
    
//    METODOS ABSTRACTOS

    @Override
    public double calcularSalario() {
        // Se suma el 20% del salario base para obtener el salario neto
        double salarioTotal = getSalarioBase() * 1.20;
        return salarioTotal;
    }
    
    @Override
    public String obtenerTipoPersona() {
        return "EMPLEADO OPERATIVO";
    }

    
}
