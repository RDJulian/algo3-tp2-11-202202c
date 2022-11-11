package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;

public class Operativo implements EstadoOperativo {

    public void operar(Estructura estructura) {
        estructura.efectuarOperacion();
    }

    public void pasarTurno(Estructura estructura) {
        estructura.pasarTurnoOperativo();
    }

}
