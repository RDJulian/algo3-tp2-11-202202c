package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Estructura.Memento;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public interface EstadoEstructura {
    void operable();

    void pasarTurno(Estructura estructura, Vida vida, Defensa defensa);

    void atacable();

    void cambiarEnergia(Memento estructura, Boolean energizado);

}
