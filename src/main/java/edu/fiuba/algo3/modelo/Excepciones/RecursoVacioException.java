package edu.fiuba.algo3.modelo.Excepciones;

public class RecursoVacioException extends RuntimeException {

    public RecursoVacioException() {
        super("El recurso que esta extrayendo ya esta vacio.");
    }
}
