package edu.fiuba.algo3.modelo.Excepciones;

public class BaseNoOpuestaException extends RuntimeException {

    public BaseNoOpuestaException() {
        super("La bases no estan en posiciones opuestas.");
    }
}
