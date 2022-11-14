package edu.fiuba.algo3.modelo.Excepciones;

public class RecursoVacio extends RuntimeException {

    public RecursoVacio() {
        super("El recurso que esta extrayendo ya esta vacio.");
    }
}
