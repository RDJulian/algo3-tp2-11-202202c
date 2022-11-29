package edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoEntidad;

public class Memento {
    //Forzado a retornar el snapshot si es la estructura la que actualiza su estado.
    private EstadoEntidad snapshot;

    public Memento(EstadoEntidad snapshot) {
        this.snapshot = snapshot;
    }

    public EstadoEntidad restaurar() {
        return this.snapshot;
    }
}
