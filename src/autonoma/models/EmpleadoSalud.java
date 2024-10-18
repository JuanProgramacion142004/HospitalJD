package autonoma.models;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */
public class EmpleadoSalud extends Empleado {

//    ATRIBUTOS
    private String especialidad;
    private int horasTrabajadas;

//    METODOS DE ACCESO
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

//    METODOS 
    public EmpleadoSalud(String especialidad,int horasTrabajadas, double salarioBase, String nombre, String numeroDocumento, int edad) {
        super(salarioBase, nombre, numeroDocumento, edad);
        this.especialidad = especialidad;
        this.horasTrabajadas = horasTrabajadas;
    }

//    METODOS ABSTRACTOS
    @Override
    public double calcularSalario() {
        // 1.2% del salario base multiplicado por las horas trabajadas y sumado al salario base
        double salarioTotal = getSalarioBase() + (getSalarioBase() * 0.012 * horasTrabajadas);
        return salarioTotal;
    }
    
    @Override
    public String obtenerTipoPersona() {
        return "EMPLEADO SALUD";
    }
}
