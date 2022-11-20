package edu.fiuba.algo3.modelo.Energizado;

import edu.fiuba.algo3.modelo.Estructura.UsaMemento;

public class SinEnergia implements Energizado {
    @Override
    public void cambiarEnergia(UsaMemento estructura, Boolean energizado) {
        if (energizado) {
            estructura.restaurarEstado();
            estructura.setEstado(new ConEnergia());
        }
    }
}
