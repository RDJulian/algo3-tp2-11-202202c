package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class ConEnergia implements EstadoEnergetico {

    @Override
    public void operar(Estructura estructura, EstadoOperativo estadoOperativo) {
        estadoOperativo.operar(estructura);
    }

    @Override
    public void pasarTurno(Estructura estructura, EstadoOperativo estadoOperativo, Vida vida, Defensa defensa) {
        estadoOperativo.pasarTurno(estructura, vida, defensa);
    }
}
