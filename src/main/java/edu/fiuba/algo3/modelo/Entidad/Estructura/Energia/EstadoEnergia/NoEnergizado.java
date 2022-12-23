package edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia;

import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo.UsaMementoOperativo;

public class NoEnergizado extends EstadoEnergia {
    @Override
    public void actualizarEstado(UsaMementoOperativo originador) {
        this.snapshot = originador.guardarEstado();
    }

    @Override
    public EstadoEnergia energizar() {
        return new Energizado(snapshot);
    }

    @Override
    public EstadoEnergia desenergizar() {
        return this;
    }
}
