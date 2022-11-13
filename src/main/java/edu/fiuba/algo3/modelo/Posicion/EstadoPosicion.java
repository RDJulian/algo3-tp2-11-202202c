package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupada;

public interface EstadoPosicion {

    void ocupable() throws PosicionOcupada;

}
