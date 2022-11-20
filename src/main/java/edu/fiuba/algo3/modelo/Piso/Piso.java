package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public interface Piso {
    boolean fueraDeRango(Posicion posicion);

    void construible(Construible sobreRango, Posicion posicion);

    //No todas pasan turno.
    void pasarTurno();
}
