package autonoma.excepciones;

public class PresupuestoNegativoException extends Exception {
    // Constructor que recibe un mensaje de error
    public PresupuestoNegativoException(String message) {
        super(message);
    }
}
