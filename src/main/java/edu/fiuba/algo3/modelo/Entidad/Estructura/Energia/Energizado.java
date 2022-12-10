package edu.fiuba.algo3.modelo.Entidad.Estructura.Energia;

import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoOperativo;

public class Energizado extends EstadoEnergia {
    @Override
    public void actualizarEstado(UsaMementoOperativo originador) {
        originador.restaurarEstado(snapshot);
    }
}