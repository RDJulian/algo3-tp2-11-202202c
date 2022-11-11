package edu.fiuba.algo3.modelo.Excepciones;

public class RecursoInsuficiente extends RuntimeException {

    public RecursoInsuficiente() {
        super("La reserva no tiene el recurso suficiente para construir esta estructura.");
    }
}
