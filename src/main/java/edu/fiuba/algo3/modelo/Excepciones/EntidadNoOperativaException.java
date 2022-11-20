package edu.fiuba.algo3.modelo.Excepciones;

public class EntidadNoOperativaException extends RuntimeException {

    public EntidadNoOperativaException() {
        super("La entidad se encuentra en construcción");
    }

}
