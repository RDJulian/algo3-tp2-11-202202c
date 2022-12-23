package edu.fiuba.algo3.modelo.Excepciones;

public class EvolucionNoValidaException extends RuntimeException {

    public EvolucionNoValidaException() {
        super("La evolucion que quiere realizar no es posible.");
    }
}
