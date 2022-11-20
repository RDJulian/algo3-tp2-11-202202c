package edu.fiuba.algo3.modelo.EstadoEntidad;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EstructuraNoOperativaException;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class SinEnergia implements EstadoEntidad {
    //Supuesto: una estructura Protoss sin energia (Acceso y Puerto Estelar) no pueden hacer nada
    //cuando no estan en el rango de un Pilon. Esto significa que su escudo no puede regenerarse.
    @Override
    public void operable() {
        throw new EstructuraNoOperativaException();
    }

    @Override
    public void pasarTurno(Estructura estructura, Vida vida, Defensa defensa) {
    }

    @Override
    public void atacable() {
    }
}
