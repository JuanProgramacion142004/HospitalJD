package autonoma.models;
import java.time.LocalDate;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */

public class CitaMedica {
    // ATRIBUTOS
    private Paciente paciente;
    private EmpleadoSalud medico;
    private LocalDate fecha;
    private double valor;

    // METODOS DE ACCESO
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

    // METODOS
    public CitaMedica(Paciente paciente, EmpleadoSalud medico, LocalDate fecha, double valor) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.valor = valor;
    }
}
