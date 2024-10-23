package autonoma.models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */

public class Inventario {

    // ATRIBUTOS
    private static int contadorInventario = 0;
    private int codigo;
    private LocalDate fecha;
    private ArrayList<Medicamento> medicamentos;

    // MÉTODOS DE ACCESO

    public static int getContadorInventario() {
        return contadorInventario;
    }

    public static void setContadorInventario(int contadorInventario) {
        Inventario.contadorInventario = contadorInventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }    

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
        
    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos; // Método existente
    }

    // Opción: agregar este método si prefieres el nombre getListaMedicamentos()
    public ArrayList<Medicamento> getListaMedicamentos() {
        return medicamentos; // Método adicional
    }

    // CONSTRUCTOR
    public Inventario(int codigo, LocalDate fecha) {
        this.codigo = ++contadorInventario;
        this.fecha = fecha;
        this.medicamentos = medicamentos; 
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
