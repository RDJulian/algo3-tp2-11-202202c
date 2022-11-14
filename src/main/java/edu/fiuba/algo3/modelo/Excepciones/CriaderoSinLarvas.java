package edu.fiuba.algo3.modelo.Excepciones;

public class CriaderoSinLarvas extends RuntimeException {

    public CriaderoSinLarvas() {
        super("Este criadero no cuenta con mas larvas.");
    }
}
