package edu.fiuba.algo3.modelo.Entidad.Estructura.Energia;

import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoOperativo;

public class NoEnergizado extends EstadoEnergia {
    @Override
    public void actualizarEstado(UsaMementoOperativo originador) {
        this.snapshot = originador.guardarEstado();
    }
}
