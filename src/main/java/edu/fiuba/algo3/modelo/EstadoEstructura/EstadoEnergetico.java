package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;

public interface EstadoEnergetico {

    void operar(Estructura estructura, EstadoOperativo estadoOperativo);

    void pasarTurno(Estructura estructura, EstadoOperativo estadoOperativo);
}
