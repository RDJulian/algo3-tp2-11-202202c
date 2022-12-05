package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public interface EstadoOperativo {
    //El estado de una entidad determina como pasa el turno, si puede hacer
    //lo que hace, si regenera o no su vida/escudo, y si es atacable.
    //Se agrega que el estado es el que determina si una entidad suma o no suministro.

    void operable();

    EstadoOperativo pasarTurno(Vida vida, Defensa defensa);

    void atacable();

    int afectarSuministro(AfectaSuministro rol, int suministro);
}
