package edu.fiuba.algo3.modelo.Excepciones;

public class MovimientoNoValidoException extends RuntimeException {

    public MovimientoNoValidoException() {
        super("Esta unidad no puede moverse por el area deseada.");
    }
}
