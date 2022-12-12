package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;

public interface EstadoInvisibilidad {
    //Esta solucion es la mas sencilla pero no necesariamente la mejor.
    Comando atacable(Comando comandoAtaque);
}
