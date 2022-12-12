package edu.fiuba.algo3.modelo.Excepciones;

public class ConstructorNoInicializadoException extends RuntimeException {

    public ConstructorNoInicializadoException() {
        super("El constructor no esta inicializado.");
    }
}
