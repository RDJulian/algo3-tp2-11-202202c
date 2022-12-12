package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad;

import edu.fiuba.algo3.modelo.Entidad.Comando.Comando;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;

public class Invisible implements EstadoInvisibilidad {
    @Override
    public Comando atacable(Comando comandoAtaque) {
        throw new AtaqueNoValidoException();
    }
}
