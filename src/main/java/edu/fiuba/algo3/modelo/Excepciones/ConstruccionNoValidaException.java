package edu.fiuba.algo3.modelo.Excepciones;

public class ConstruccionNoValidaException extends RuntimeException {

    public ConstruccionNoValidaException() {
        super("No se puede contruir la entidad deseada con las condiciones actuales.");
    }
}
