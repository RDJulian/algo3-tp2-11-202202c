package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.AccionAlPasarTurno;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.RolEnSuministro.RolEnSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public class Destruido extends EstadoEntidad {
    @Override
    public void operable() {
        throw new EntidadDestruidaException();
    }

    @Override
    public EstadoEntidad pasarTurno(Vida vida, Defensa defensa) {
        return this;
    }

    @Override
    public EstadoEntidad pasarTurno(Vida vida, Defensa defensa, AccionAlPasarTurno entidad) {
        return this;
    }

    @Override
    public void atacable() {
        throw new EntidadDestruidaException();
    }

    @Override
    public int afectarSuministro(RolEnSuministro rol, int suministro) {
        return suministro;
    }
}
