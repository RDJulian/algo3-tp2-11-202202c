package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;

public class Operativo implements EstadoEstructura {

    public void efectuarEstado(){};

    public void pasarTurnoCon(Estructura estructura) {
        estructura.pasarTurnoOperativo();
    };
}
