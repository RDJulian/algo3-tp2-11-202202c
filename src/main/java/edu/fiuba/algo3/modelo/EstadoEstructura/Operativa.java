package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.Memento;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Operativa implements EstadoEstructura {
    @Override
    public void operable() {
    }

    @Override
    public void pasarTurno(Estructura estructura, Vida vida, Defensa defensa) {
        estructura.pasarTurnoOperativo();
        vida.regenerar();
        defensa.regenerar();
    }

    @Override
    public void atacable() {
    }

    @Override
    public void cambiarEnergia(Memento estructura, Boolean energizado) {
        if (!energizado) {
            estructura.guardarEstado();
            estructura.setEstado(new SinEnergia());
        }
    }
}
