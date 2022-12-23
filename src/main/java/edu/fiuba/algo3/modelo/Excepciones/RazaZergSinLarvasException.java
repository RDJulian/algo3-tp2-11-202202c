package edu.fiuba.algo3.modelo.Excepciones;

public class RazaZergSinLarvasException extends RuntimeException {

    public RazaZergSinLarvasException() {
        super("La raza Zerg no tiene larvas para engendrar esta Unidad.");
    }
}
