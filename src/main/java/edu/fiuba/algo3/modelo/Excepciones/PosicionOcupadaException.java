package edu.fiuba.algo3.modelo.Excepciones;

public class PosicionOcupadaException extends RuntimeException {
    public PosicionOcupadaException() {
        super("La posicion se encuentra ocupada.");
    }
}
