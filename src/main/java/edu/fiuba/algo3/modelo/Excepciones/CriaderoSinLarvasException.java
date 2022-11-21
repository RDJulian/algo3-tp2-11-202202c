package edu.fiuba.algo3.modelo.Excepciones;

public class CriaderoSinLarvasException extends RuntimeException {

    public CriaderoSinLarvasException() {
        super("Este criadero no cuenta con mas larvas.");
    }
}
