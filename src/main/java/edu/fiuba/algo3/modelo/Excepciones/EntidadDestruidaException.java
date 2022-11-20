package edu.fiuba.algo3.modelo.Excepciones;

public class EntidadDestruidaException extends RuntimeException {

    public EntidadDestruidaException() {
        super("La entidad se encuentra destruida.");
    }

}
