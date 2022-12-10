package edu.fiuba.algo3.modelo.Entidad.Estructura.Energia;

import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoOperativo;

public abstract class EstadoEnergia {
    protected MementoOperativo snapshot;

    public abstract void actualizarEstado(UsaMementoOperativo originador);
}
