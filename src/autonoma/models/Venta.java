package autonoma.models;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/16/2024
 * @version 1.0.0
 */

public class Venta {

    // ATRIBUTOS
    private int idVenta;
    private Medicamento medicamento;
    private double valorTotal;

    // METODOS DE ACCESO
    public int getIdVenta() {
        return idVenta;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    // METODOS
    public Venta(int idVenta, Medicamento medicamento, double valorTotal) {
        this.idVenta = idVenta;
        this.medicamento = medicamento;
        this.valorTotal = valorTotal;
    }
}
