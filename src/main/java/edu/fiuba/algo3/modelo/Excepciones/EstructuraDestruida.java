package edu.fiuba.algo3.modelo.Excepciones;

public class EstructuraDestruida extends RuntimeException {

    public EstructuraDestruida() {
        super("La estructura se encuentra destruida.");
    }

}
