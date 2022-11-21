package edu.fiuba.algo3.modelo.Excepciones;

public class NombreNoValidoException extends RuntimeException {

    public NombreNoValidoException() {
        super("El nombre que desea ingresar tiene menos de seis caracteres.");
    }
}
