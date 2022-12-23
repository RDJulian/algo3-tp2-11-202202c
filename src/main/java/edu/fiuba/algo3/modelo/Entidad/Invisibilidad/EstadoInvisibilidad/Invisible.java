package edu.fiuba.algo3.modelo.Entidad.Invisibilidad.EstadoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.UsaMementoInvisibilidad;

public class Invisible extends EstadoInvisibilidad {
    public Invisible(MementoInvisibilidad snapshot) {
        this.snapshot = snapshot;
    }

    public Invisible() {
    }

    @Override
    public void actualizarEstado(UsaMementoInvisibilidad originador) {
        originador.restaurarEstado(snapshot);
    }

    @Override
    public void sincronizarEstado(UsaMementoInvisibilidad originador) {
        //Nada.
    }

    @Override
    public EstadoInvisibilidad revelar() {
        return new Visible();
    }

    @Override
    public EstadoInvisibilidad ocultar() {
        return this;
    }
}
