package edu.fiuba.algo3.modelo.Excepciones;

public class MovimientoSobreRecursoException extends RuntimeException {

    public MovimientoSobreRecursoException() {
        super("Esta unidad no se puede mover sobre esta Area con un Recurso.");
    }
}
