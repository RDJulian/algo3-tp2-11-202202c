package edu.fiuba.algo3.modelo.EstadoEntidad;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Operativa implements EstadoEntidad {
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
}
