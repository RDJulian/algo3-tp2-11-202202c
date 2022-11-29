package edu.fiuba.algo3.modelo.Excepciones;

public class RecursoInsuficienteException extends RuntimeException {

    public RecursoInsuficienteException() {
        super("Las reservas no tienen el recurso suficiente para construir esta entidad.");
    }
}
