package autonoma.models;

import autonoma.excepciones.PresupuestoNegativoException;
import autonoma.excepciones.EnfermedadNoExisteException;
import java.time.LocalDate;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */
public class CitaMedica {
    // ATRIBUTOS
    private static int contadorCitas = 0; // Contador para generar IDs únicos
    private int id; // ID único de la cita
    private Paciente paciente;
    private EmpleadoSalud medico;
    private LocalDate fecha;
    private double valor;

    // MÉTODOS DE ACCESO
    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public EmpleadoSalud getMedico() {
        return medico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getValor() {
        return valor;
    }

    // CONSTRUCTOR
    public CitaMedica(Paciente paciente, EmpleadoSalud medico, LocalDate fecha, double valor) {
        this.id = ++contadorCitas; // Asigna un ID único
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.valor = valor;
    }

    // MÉTODO PARA CURAR AL PACIENTE
    public void curarPaciente(Medicamento medicamento, Hospital hospital) throws PresupuestoNegativoException, EnfermedadNoExisteException {
        // Registrar la cita en el hospital
        hospital.registrarCita(this); 

        // Sumar el valor de la cita al presupuesto del hospital
        hospital.registrarPatrocinio(valor);

        // Curar al paciente utilizando el medicamento
        paciente.curarEnfermedad(paciente.getEnfermedades().get(0).getNombre(), medicamento); // Curar la primera enfermedad del paciente
    }

    // MÉTODO PARA MOSTRAR INFORMACIÓN DE LA CITA
    @Override
    public String toString() {
        return "CitaMedica{" +
                "id=" + id +
                ", paciente=" + paciente.getNombre() +
                ", medico=" + medico.getNombre() +
                ", fecha=" + fecha +
                ", valor=" + valor +
                '}';
    }
}
