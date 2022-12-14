package edu.fiuba.algo3.modelo.Excepciones;

public class UnidadYaAtacoException extends RuntimeException {

    public UnidadYaAtacoException() {
        super("Esta unidad no puede atacar a la entidad deseada porque ya ataco este turno.");
    }
}
