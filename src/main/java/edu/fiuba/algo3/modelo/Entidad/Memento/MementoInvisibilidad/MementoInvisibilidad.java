package edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.EstadoInvisibilidadEntidad;

public class MementoInvisibilidad {
    //Forzado a retornar el snapshot si es la estructura la que actualiza su estado.
    private EstadoInvisibilidadEntidad snapshot;

    public MementoInvisibilidad(EstadoInvisibilidadEntidad snapshot) {
        this.snapshot = snapshot;
    }

    public EstadoInvisibilidadEntidad restaurar() {
        return snapshot;
    }
}
