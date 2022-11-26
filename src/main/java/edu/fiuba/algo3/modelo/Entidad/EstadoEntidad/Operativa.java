package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Operativa implements EstadoEntidad {
    @Override
    public void operable() {
    }

    @Override
    public EstadoEntidad pasarTurno(Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa) {
        vida.regenerar();
        defensa.regenerar();
        accionAlPasarTurno.ejecutar();
        return this;
    }

    @Override
    public void atacable() {
    }
}
