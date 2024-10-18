package autonoma.excepciones;

/**
 *
 * @author Juan David Arcila
 * @fecha 10/18/2024
 * @version 1.0.0
 */

public class EnfermedadNoExisteException extends RuntimeException {
    public EnfermedadNoExisteException(String mensaje) {
        super(mensaje);
    }
}