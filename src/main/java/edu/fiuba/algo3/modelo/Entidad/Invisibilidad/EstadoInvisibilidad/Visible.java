package edu.fiuba.algo3.modelo.Entidad.Invisibilidad.EstadoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.UsaMementoInvisibilidad;

public class Visible extends EstadoInvisibilidad {
    @Override
    public void actualizarEstado(UsaMementoInvisibilidad originador) {
        snapshot = originador.guardarEstado();
    }

    @Override
    public void sincronizarEstado(UsaMementoInvisibilidad originador) {
        actualizarEstado(originador);
    }

    @Override
    public EstadoInvisibilidad revelar() {
        return this;
    }

    @Override
    public EstadoInvisibilidad ocultar() {
        return new Invisible(snapshot);
    }
}
