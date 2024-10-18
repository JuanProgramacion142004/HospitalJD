package autonoma.models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author Juan David Arcila
 * @fecha 10/17/2024
 * @version 1.0.1
 */
public class Nomina {

    // ATRIBUTOS
    private String idNomina;
    private LocalDate fecha;
    private double totalNomina;
    private List<Empleado> empleados;

    // METODOS DE ACCESO
    public String getIdNomina() {
        return idNomina;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getTotalNomina() {
        return totalNomina;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    // CONSTRUCTOR
    public Nomina(List<Empleado> empleados) {
        this.idNomina = generarIdUnico();
        // La fecha de la nómina se instancia con la fecha actual
        this.fecha = LocalDate.now();
        this.empleados = empleados;
        // Calcula la nómina al instanciar
        this.totalNomina = calcularTotalNomina();
    }

    // MÉTODO para generar un identificador único
    private String generarIdUnico() {
        return UUID.randomUUID().toString(); // Genera un identificador único
    }

    // MÉTODO para calcular el total de la nómina sumando los salarios de todos los empleados
    private double calcularTotalNomina() {
        double total = 0;
        for (Empleado empleado : empleados) {
            total += empleado.calcularSalario();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Nómina [ID: " + idNomina + ", Fecha: " + fecha + ", Total: " + totalNomina + "]";
    }

    // MÉTODO para procesar la nómina y descontar del presupuesto del hospital
    public void procesarNomina(Hospital hospital) throws Exception {
        if (hospital.getEstado().equalsIgnoreCase("EN QUIEBRA")) {
            throw new Exception("Error: El hospital está en quiebra y no puede procesar nómina.");
        }

        double presupuestoActual = hospital.getPresupuesto();

        if (presupuestoActual >= totalNomina) {
            hospital.setPresupuesto(presupuestoActual - totalNomina);
            System.out.println("Nómina procesada exitosamente. El presupuesto del hospital ha sido actualizado.");
        } else {
            hospital.setPresupuesto(presupuestoActual - totalNomina); // Presupuesto negativo
            hospital.setEstado("EN QUIEBRA"); // Cambiar estado a "EN QUIEBRA"
            System.out.println("El hospital ha entrado en quiebra. No se pueden procesar más nóminas hasta reparar el presupuesto.");
        }
    }
}
