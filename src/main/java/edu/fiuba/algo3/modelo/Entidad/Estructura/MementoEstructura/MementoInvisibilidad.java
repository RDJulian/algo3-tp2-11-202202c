package edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

public class MementoInvisibilidad {
    //Forzado a retornar el snapshot si es la estructura la que actualiza su estado.
    private EstadoInvisibilidad snapshot;

    public MementoInvisibilidad(EstadoInvisibilidad snapshot) {
        this.snapshot = snapshot;
    }

    public EstadoInvisibilidad restaurar() {
        return this.snapshot;
    }
}
