package edu.fiuba.algo3.modelo.Excepciones;

public class AtaqueNoValidoException extends RuntimeException {

    public AtaqueNoValidoException() {
        super("Esta unidad no puede atacar a la entidad deseada.");
    }
}
