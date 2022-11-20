package edu.fiuba.algo3.modelo.EstadoEntidad;

import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Operativa implements EstadoEntidad {
    @Override
    public void operable() {
    }

    @Override
    public void pasarTurno(Estructura estructura, Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa) {
        accionAlPasarTurno.ejecutar();
        vida.regenerar();
        defensa.regenerar();
    }

    @Override
    public void atacable() {
    }
}
