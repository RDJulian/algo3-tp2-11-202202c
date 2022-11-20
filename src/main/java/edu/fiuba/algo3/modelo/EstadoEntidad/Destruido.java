package edu.fiuba.algo3.modelo.EstadoEntidad;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraDestruidaException;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Destruido implements EstadoEntidad {
    @Override
    public void operable() {
        throw new EstructuraDestruidaException();
    }

    @Override
    public void pasarTurno(Estructura estructura, Vida vida, Defensa defensa) {
    }

    @Override
    public void atacable() {
        throw new EstructuraDestruidaException();
    }
}
