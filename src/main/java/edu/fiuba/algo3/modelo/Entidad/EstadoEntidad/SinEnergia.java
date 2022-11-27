package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.RolEnSuministro.RolEnSuministro;
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
    public EstadoEntidad pasarTurno(Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa) {
        return this;
    }

    @Override
    public void atacable() {
    }

    @Override
    public boolean visitar(RolEnSuministro rol) {
        return rol.visitar(this);
    }
}
