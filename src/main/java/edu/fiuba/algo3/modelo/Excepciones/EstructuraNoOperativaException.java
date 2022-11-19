package edu.fiuba.algo3.modelo.Excepciones;

public class EstructuraNoOperativaException extends RuntimeException {

    public EstructuraNoOperativaException() {
        super("La estructura se encuentra en construcción");
    }

}
