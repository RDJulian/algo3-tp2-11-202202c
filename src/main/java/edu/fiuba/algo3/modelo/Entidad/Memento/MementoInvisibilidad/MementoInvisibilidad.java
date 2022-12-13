package edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.EstadoInvisibilidad;

public class MementoInvisibilidad {
    //Forzado a retornar el snapshot si es la estructura la que actualiza su estado.
    private EstadoInvisibilidad snapshot;

    public MementoInvisibilidad(EstadoInvisibilidad snapshot) {
        this.snapshot = snapshot;
    }

    public EstadoInvisibilidad restaurar() {
        return snapshot;
    }
}
