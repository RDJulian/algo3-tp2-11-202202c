package edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia;

import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo.UsaMementoOperativo;

public class Energizado extends EstadoEnergia {
    public Energizado(MementoOperativo snapshot) {
        this.snapshot = snapshot;
    }

    public Energizado() {
    }

    @Override
    public void actualizarEstado(UsaMementoOperativo originador) {
        originador.restaurarEstado(snapshot);
    }

    @Override
    public EstadoEnergia energizar() {
        return this;
    }

    @Override
    public EstadoEnergia desenergizar() {
        return new NoEnergizado();
    }
}