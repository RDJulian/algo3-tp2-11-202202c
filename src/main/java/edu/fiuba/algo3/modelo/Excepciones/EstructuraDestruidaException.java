package edu.fiuba.algo3.modelo.Excepciones;

public class EstructuraDestruidaException extends RuntimeException {

    public EstructuraDestruidaException() {
        super("La estructura se encuentra destruida.");
    }

}
