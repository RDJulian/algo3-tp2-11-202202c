package edu.fiuba.algo3.modelo.Excepciones;

public class SuministroInsuficienteException extends RuntimeException {

    public SuministroInsuficienteException() {
        super("No hay mas suministro para construir esta unidad.");
    }
}
