package edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

public class MementoOperativo {
    //Forzado a retornar el snapshot si es la estructura la que actualiza su estado.
    private EstadoOperativo snapshot;

    public MementoOperativo(EstadoOperativo snapshot) {
        this.snapshot = snapshot;
    }

    public EstadoOperativo restaurar() {
        return this.snapshot;
    }
}
