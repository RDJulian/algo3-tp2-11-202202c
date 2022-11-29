package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public interface Piso {
    boolean fueraDeRango(Posicion posicion);

    void construible(ConstruiblePiso sobreRango, Posicion posicion);

    //Ver si pasar turno es necesario.
    void pasarTurno();
}
