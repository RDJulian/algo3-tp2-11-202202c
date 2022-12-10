package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Vida.Defensa;
import edu.fiuba.algo3.modelo.Entidad.Vida.Vida;

public interface EstadoOperativo {
    //El estado de una entidad determina como pasa el turno, si puede hacer
    //lo que hace, si regenera o no su vida/escudo, y si es atacable.
    //Se agrega que el estado es el que determina si una entidad suma o no suministro.

    void operable(Comando comando);

    EstadoOperativo pasarTurno(Vida vida, Defensa defensa, Comando comandoPorTurno);

    void atacable(Comando comando);

    int afectarSuministro(AfectaSuministro rol, int suministro);
}
