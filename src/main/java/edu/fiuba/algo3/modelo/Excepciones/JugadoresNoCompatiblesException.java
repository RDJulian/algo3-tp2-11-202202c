package edu.fiuba.algo3.modelo.Excepciones;

public class JugadoresNoCompatiblesException extends RuntimeException {

    public JugadoresNoCompatiblesException() {
        super("Los jugadores no son compatibles.");
    }
}
