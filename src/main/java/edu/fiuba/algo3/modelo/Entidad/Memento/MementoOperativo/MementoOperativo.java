package edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EstadoOperativo;

public class MementoOperativo {
    //Forzado a retornar el snapshot si es la estructura la que actualiza su estado.
    private EstadoOperativo snapshot;

    public MementoOperativo(EstadoOperativo snapshot) {
        this.snapshot = snapshot;
    }

    public EstadoOperativo restaurar() {
        return snapshot;
    }
}
