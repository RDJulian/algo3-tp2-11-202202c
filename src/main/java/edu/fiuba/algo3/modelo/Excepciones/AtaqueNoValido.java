package edu.fiuba.algo3.modelo.Excepciones;

public class AtaqueNoValido extends RuntimeException {

    public AtaqueNoValido() {
        super("Esta unidad no puede atacar a la unidad deseada.");
    }
}
