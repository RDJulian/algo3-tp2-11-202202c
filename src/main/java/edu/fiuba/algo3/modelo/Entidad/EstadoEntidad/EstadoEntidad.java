package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.RolEnSuministro.RolEnSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class EstadoEntidad {
    //El estado de una entidad determina como pasa el turno, si puede hacer
    //lo que hace, si regenera o no su vida/escudo, y si es atacable.
    //Se agrega que el estado es el que determina si una entidad suma o no suministro.
    protected RolEnSuministro rol;

    public EstadoEntidad() {
        this.rol = new Neutral();
    }

    public EstadoEntidad(RolEnSuministro rol) {
        this.rol = rol;
    }

    public abstract void operable();

    public abstract EstadoEntidad pasarTurno(Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa);

    public abstract void atacable();

    public abstract int afectarSuministro(int suministro);
}
