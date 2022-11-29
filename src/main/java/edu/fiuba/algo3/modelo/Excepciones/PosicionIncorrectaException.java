package edu.fiuba.algo3.modelo.Excepciones;

public class PosicionIncorrectaException extends RuntimeException {

    public PosicionIncorrectaException() {
        super("La posicion del recurso no coincide con la de la Entidad.");
    }
}
