package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;

public interface EstadoEstructura {
    void efectuarEstado();

    void pasarTurnoCon(Estructura estructura);
}
