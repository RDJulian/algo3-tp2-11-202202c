package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public interface EstadoEntidad {
    //El estado de una entidad determina como pasa el turno, si puede hacer
    //lo que hace, si regenera o no su vida/escudo, y si es atacable.
    void operable();

    EstadoEntidad pasarTurno(Ejecutar accionAlPasarTurno, Vida vida, Defensa defensa);

    void atacable();
}
