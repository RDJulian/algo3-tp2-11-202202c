package edu.fiuba.algo3.modelo.MementoEstructura;

import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;
import edu.fiuba.algo3.modelo.Estructura.Estructura;

public class Memento {
    private EstadoEntidad snapshot;

    public Memento(EstadoEntidad snapshot) {
        this.snapshot = snapshot;
    }

    public void restaurar(Estructura estructura) {
        estructura.setEstado(this.snapshot);
    }
}
