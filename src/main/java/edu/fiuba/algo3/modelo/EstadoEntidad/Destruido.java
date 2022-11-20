package edu.fiuba.algo3.modelo.EstadoEntidad;

import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Destruido implements EstadoEntidad {
    @Override
    public void operable() {
        throw new EntidadDestruidaException();
    }

    @Override
    public void pasarTurno(Estructura estructura, Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa) {
    }

    @Override
    public void atacable() {
        throw new EntidadDestruidaException();
    }
}
