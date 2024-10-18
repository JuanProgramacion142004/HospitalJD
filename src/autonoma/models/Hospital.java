package autonoma.models;

import autonoma.excepciones.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan David Arcila
 * @fecha 10/15/2024
 * @version 2.0.0
 */
public class Hospital {

    // ATRIBUTOS
    private String nombre;
    private String direccion;
    private String telefono;
    private String logo;
    private String estado; // Activo o En quiebra
    private LocalDate fechaFundacion;
    private double presupuesto;
    private double metaVentasAnual;
    private Gerente gerente;
    private Localizacion localizacion;
    private Inventario inventario; 
    private List<Empleado> empleados;
    private List<Paciente> pacientes;
    private List<CitaMedica> citas;
    private List<Medicamento> medicamentos; 
    

    // MÉTODOS DE ACCESO
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getMetaVentasAnual() {
        return metaVentasAnual;
    }

    public void setMetaVentasAnual(double metaVentasAnual) {
        this.metaVentasAnual = metaVentasAnual;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<CitaMedica> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaMedica> citas) {
        this.citas = citas;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    

    // METODOS
    public Hospital(String nombre, String direccion, String telefono, String logo, LocalDate fechaFundacion,
            double presupuesto, double metaVentasAnual, Localizacion localizacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.logo = logo;
        this.estado = "ACTIVO";
        this.fechaFundacion = fechaFundacion;
        this.presupuesto = presupuesto;
        this.metaVentasAnual = metaVentasAnual;
        this.localizacion = localizacion;
        this.inventario = new Inventario();
        this.empleados = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.medicamentos = new ArrayList<>(); // Inicializa la lista de medicamentos
    }

    // MÉTODOS PARA GESTIONAR EMPLEADOS
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public List<Empleado> obtenerEmpleados() {
        return empleados;
    }

    // MÉTODOS PARA GESTIONAR PACIENTES
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void eliminarPaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    public List<Paciente> obtenerPacientes() {
        return pacientes;
    }

    // MÉTODOS PARA GESTIONAR CITAS
    public void registrarCita(CitaMedica cita) {
        citas.add(cita);
    }

    public void eliminarCita(CitaMedica cita) {
        citas.remove(cita);
    }

    public List<CitaMedica> obtenerCitas() {
        return citas;
    }

    // MÉTODOS PARA GESTIONAR MEDICAMENTOS
    public void registrarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
        System.out.println("Medicamento " + medicamento.getNombre() + " registrado en el hospital.");
    }

    public List<Medicamento> obtenerMedicamentos() {
        return medicamentos;
    }

    // MÉTODO PARA DESCONTAR DEL PRESUPUESTO
    public void descontarPresupuesto(double monto) throws PresupuestoNegativoException {
        presupuesto -= monto;
        if (presupuesto < 0) {
            estado = "EN QUIEBRA";
            throw new PresupuestoNegativoException("El hospital ha entrado en quiebra. Presupuesto negativo: " + presupuesto);
        }
    }
    
    public void procesoNomina() throws PresupuestoNegativoException {
    double totalNomina = 0.0;

    // Recorrer todos los empleados del hospital y sumar sus salarios
    for (Empleado empleado : empleados) {
        double salario = empleado.calcularSalario();
        totalNomina += salario;
        System.out.println("Pagando salario de " + empleado.getNombre() + ": $" + salario);
    }

    // Restar el total de la nómina del presupuesto
    descontarPresupuesto(totalNomina);

    System.out.println("Proceso de nómina completado. Total pagado: $" + totalNomina);
}

    // MÉTODO PARA REGISTRAR PATROCINIO
    public void registrarPatrocinio(double monto) {
        presupuesto += monto;
        if (presupuesto >= 0) {
            estado = "ACTIVO";
            System.out.println("El hospital ha subsanado su deuda y ahora está activo.");
        }
    }

    // MÉTODO PARA VERIFICAR VENTAS ANUALES
    public void verificarVentasAnuales(double ventasAnuales) throws FestividadException {
        if (ventasAnuales > metaVentasAnual) {
            throw new FestividadException("¡Se ha superado la meta anual! Evento de festividad activado.");
        }
    }

    // MÉTODO PARA AUMENTAR PRESUPUESTO POR FESTIVIDAD
    public void aumentarPresupuestoPorFestividad() {
        presupuesto += presupuesto * 0.10;
        System.out.println("Presupuesto incrementado en un 10% por la celebración.");
    }
}
