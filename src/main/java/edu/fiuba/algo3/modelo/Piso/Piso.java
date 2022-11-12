package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Posicion.Posicion;

public interface Piso {
    boolean enRango(Posicion posicion);

    void pasarTurno();
}
