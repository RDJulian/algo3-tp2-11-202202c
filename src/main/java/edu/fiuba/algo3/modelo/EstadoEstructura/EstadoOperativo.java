package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;

public interface EstadoOperativo {
    void operar(Estructura estructura);

    void pasarTurno(Estructura estructura);
}
