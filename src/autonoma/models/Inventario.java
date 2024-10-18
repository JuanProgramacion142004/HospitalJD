package autonoma.models;

import java.util.ArrayList;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */

public class Inventario {

    // ATRIBUTOS
    private ArrayList<Medicamento> medicamentos;

    // MÉTODOS DE ACCESO
    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos; // Método existente
    }

    // Opción: agregar este método si prefieres el nombre getListaMedicamentos()
    public ArrayList<Medicamento> getListaMedicamentos() {
        return medicamentos; // Método adicional
    }

    // CONSTRUCTOR
    public Inventario() {
        medicamentos = new ArrayList<>(); // Inicializa la lista de medicamentos
    }

    // MÉTODO PARA AGREGAR UN MEDICAMENTO
    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    // MÉTODO PARA BUSCAR UN MEDICAMENTO POR NOMBRE
    public Medicamento buscarMedicamento(String nombre) {
        for (Medicamento med : medicamentos) {
            if (med.getNombre().equalsIgnoreCase(nombre)) {
                return med; // Retorna el medicamento encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }
}
