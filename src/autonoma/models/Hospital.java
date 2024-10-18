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

    private List<Empleado> empleados;
    private List<Paciente> pacientes;
    private List<CitaMedica> citas;

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

    // CONSTRUCTOR
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

        this.empleados = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
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

    // MÉTODO PARA DESCONTAR DEL PRESUPUESTO
    public void descontarPresupuesto(double monto) throws PresupuestoNegativoException {
        presupuesto -= monto;
        if (presupuesto < 0) {
            estado = "EN QUIEBRA";
            throw new PresupuestoNegativoException("El hospital ha entrado en quiebra. Presupuesto negativo: " + presupuesto);
        }
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
