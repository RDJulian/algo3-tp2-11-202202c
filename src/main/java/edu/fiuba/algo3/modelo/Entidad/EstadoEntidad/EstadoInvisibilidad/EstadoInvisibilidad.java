package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;

public interface EstadoInvisibilidad {
    Comando atacable(Comando comando);
}
