package autonoma.models;

import autonoma.excepciones.MedicamentoRecetadoException;
import autonoma.excepciones.EnfermedadNoExisteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 2.0.0
 */
public class Paciente extends Persona {
    // ATRIBUTOS
    private String correoElectronico;
    private String telefono;
    private String estado; // Saludable o Crítico
    private ArrayList<Enfermedad> enfermedades;
    private List<Medicamento> medicinas;

    // CONSTRUCTOR
    public Paciente(String nombre, String numeroDocumento, int edad, String correoElectronico, String telefono) {
        super(nombre, numeroDocumento, edad);
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.estado = "Saludable";
        this.enfermedades = new ArrayList<>();
        this.medicinas = new ArrayList<>();
    }

    // METODOS DE ACCESO
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public List<Medicamento> getMedicinas() {
        return medicinas;
    }

    // METODOS
    public void curarEnfermedad(String nombreEnfermedad, Medicamento medicamento) 
            throws EnfermedadNoExisteException, MedicamentoRecetadoException {
        Enfermedad enfermedadCurada = null;

        // Buscar la enfermedad en la lista
        for (Enfermedad e : enfermedades) {
            if (e.getNombre().equalsIgnoreCase(nombreEnfermedad)) {
                enfermedadCurada = e;
                break;
            }
        }

        // Si la enfermedad no existe
        if (enfermedadCurada == null) {
            throw new EnfermedadNoExisteException("El paciente no tiene registrada la enfermedad: " + nombreEnfermedad);
        }

        // Verificar si el medicamento ya ha sido recetado
        for (Medicamento med : medicinas) {
            if (med.getNombre().equalsIgnoreCase(medicamento.getNombre())) {
                throw new MedicamentoRecetadoException("El medicamento " + medicamento.getNombre() + " ya fue recetado.");
            }
        }

        // Curar la enfermedad
        enfermedades.remove(enfermedadCurada);
        medicinas.add(medicamento);
        System.out.println("Enfermedad " + nombreEnfermedad + " curada con el medicamento " + medicamento.getNombre());

        // Actualizar estado del paciente
        if (enfermedades.isEmpty()) {
            estado = "Saludable";
        } else {
            estado = "Crítico";
        }
    }

    // METODOS ABSTRACTOS
    @Override
    public String obtenerTipoPersona() {
        return "PACIENTE";
    }
}
