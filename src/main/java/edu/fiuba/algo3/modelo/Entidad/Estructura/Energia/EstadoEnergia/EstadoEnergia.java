package edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia;

import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo.UsaMementoOperativo;

public abstract class EstadoEnergia {
    protected MementoOperativo snapshot;

    public abstract void actualizarEstado(UsaMementoOperativo originador);

    public abstract EstadoEnergia energizar();

    public abstract EstadoEnergia desenergizar();
}
