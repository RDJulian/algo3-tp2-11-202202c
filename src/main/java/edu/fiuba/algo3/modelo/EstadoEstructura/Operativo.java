package edu.fiuba.algo3.modelo.EstadoEstructura;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Operativo implements EstadoOperativo {

    public void operar(Estructura estructura) {
        estructura.efectuarOperacion();
    }

    public void pasarTurno(Estructura estructura, Vida vida, Defensa defensa) {
        estructura.pasarTurnoOperativo();
        vida.regenerar();
        defensa.regenerar();
    }

    @Override
    public void atacable() {

    }

}
