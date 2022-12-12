package edu.fiuba.algo3.modelo.Entidad.Invisibilidad.EstadoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.UsaMementoInvisibilidad;

public abstract class EstadoInvisibilidad {
    protected MementoInvisibilidad snapshot;

    public abstract void actualizarEstado(UsaMementoInvisibilidad originador);

    public abstract void sincronizarEstado(UsaMementoInvisibilidad originador);

    public abstract EstadoInvisibilidad revelar();

    public abstract EstadoInvisibilidad ocultar();
}
