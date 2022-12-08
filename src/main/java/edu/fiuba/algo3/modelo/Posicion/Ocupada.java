package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;

public class Ocupada implements EstadoPosicion {
    @Override
    public EstadoPosicion ocupar() {
        throw new PosicionOcupadaException();
    }
}
