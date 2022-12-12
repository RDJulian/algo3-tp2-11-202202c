package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Entidad.Comando.ComandoBool;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.Escudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Vida;

public interface EstadoOperativo {
    //El estado de una entidad determina como pasa el turno, si puede hacer
    //lo que hace, si regenera o no su vida/escudo, y si es atacable.
    //Se agrega que el estado es el que determina si una entidad suma o no suministro.

    void operable(Comando comando);

    boolean operable(ComandoBool comando);

    EstadoOperativo pasarTurno(Vida vida, Escudo escudo, Comando comandoAlPasarTurno);

    void atacable(Comando comandoAtaque);

    int afectarSuministro(AfectaSuministro afectaSuministro, int suministro);
}
