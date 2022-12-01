package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.AccionAlPasarTurno;
import edu.fiuba.algo3.modelo.RolEnSuministro.RolEnSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class EstadoEntidad {
    //El estado de una entidad determina como pasa el turno, si puede hacer
    //lo que hace, si regenera o no su vida/escudo, y si es atacable.
    //Se agrega que el estado es el que determina si una entidad suma o no suministro.

    public abstract void operable();

    //Solo difiere una.
    public abstract EstadoEntidad pasarTurno(Vida vida, Defensa defensa);

    public abstract EstadoEntidad pasarTurno(Vida vida, Defensa defensa, AccionAlPasarTurno entidad);

    public abstract void atacable();

    public abstract int afectarSuministro(RolEnSuministro rol, int suministro);
}