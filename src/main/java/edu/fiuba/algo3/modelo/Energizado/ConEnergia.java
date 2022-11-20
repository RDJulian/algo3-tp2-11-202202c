package edu.fiuba.algo3.modelo.Energizado;

import edu.fiuba.algo3.modelo.EstadoEntidad.SinEnergia;
import edu.fiuba.algo3.modelo.MementoEstructura.UsaMemento;

public class ConEnergia implements Energizado {
    @Override
    public void cambiarEnergia(UsaMemento estructura, Boolean energizado) {
        if (!energizado) {
            estructura.guardarEstado();
            estructura.setEstado(new SinEnergia());
            estructura.setEstado(new edu.fiuba.algo3.modelo.Energizado.SinEnergia());
        }
    }
}
