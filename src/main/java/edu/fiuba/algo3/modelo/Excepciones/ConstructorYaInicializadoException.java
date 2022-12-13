package edu.fiuba.algo3.modelo.Excepciones;

public class ConstructorYaInicializadoException extends RuntimeException {

    public ConstructorYaInicializadoException() {
        super("El constructor ya esta inicializado.");
    }
}
