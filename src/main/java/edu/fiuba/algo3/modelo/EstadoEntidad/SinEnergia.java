package edu.fiuba.algo3.modelo.EstadoEntidad;

import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class SinEnergia implements EstadoEntidad {
    //Supuesto: una estructura Protoss sin energia (Acceso y Puerto Estelar) no pueden hacer nada
    //cuando no estan en el rango de un Pilon. Esto significa que su escudo no puede regenerarse.
    @Override
    public void operable() {
        throw new EntidadNoOperativaException();
    }

    @Override
    public void pasarTurno(Estructura estructura, Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa) {
    }

    @Override
    public void pasarTurno(Unidad unidad, Vida vida, Defensa defensa) {
        //No aplica.
    }

    @Override
    public void atacable() {
    }
}
