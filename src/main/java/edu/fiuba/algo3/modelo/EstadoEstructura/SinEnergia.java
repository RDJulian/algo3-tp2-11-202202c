package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraNoOperativa;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class SinEnergia implements EstadoEnergetico {

    @Override
    public void operar(Estructura estructura, EstadoOperativo estadoOperativo) {
        throw new EstructuraNoOperativa();
    }

    @Override
    public void pasarTurno(Estructura estructura, EstadoOperativo estadoOperativo, Vida vida, Defensa defensa) {

    }
}
