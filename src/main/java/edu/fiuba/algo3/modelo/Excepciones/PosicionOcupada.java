package edu.fiuba.algo3.modelo.Excepciones;

public class PosicionOcupada extends RuntimeException {
    public PosicionOcupada() {
        super("La posición ocupada no puede ser utilizable");
    }
}
