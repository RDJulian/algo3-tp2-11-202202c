package edu.fiuba.algo3.modelo.Entidad.EstadoEntidad;

import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;

public class Invisible implements EstadoInvisibilidad {
    @Override
    public void atacable() {
        throw new AtaqueNoValidoException();
    }
}
