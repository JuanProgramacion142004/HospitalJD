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

    // METODOS DE ACCESO
    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    // METODOS
    public Inventario() {
        medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public Medicamento buscarMedicamento(String nombre) {
        for (Medicamento med : medicamentos) {
            if (med.getNombre().equalsIgnoreCase(nombre)) {
                return med;
            }
        }
        return null;
    }
}
