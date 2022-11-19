package edu.fiuba.algo3.modelo.Excepciones;

public class RecursoInsuficienteException extends RuntimeException {

    public RecursoInsuficienteException() {
        super("La reserva no tiene el recurso suficiente para construir esta estructura.");
    }
}
