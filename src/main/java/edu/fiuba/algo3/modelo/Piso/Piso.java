package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRango;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public interface Piso {
    boolean fueraDeRango(Posicion posicion);

    void construible(ConstruibleSobreRango sobreRango, Posicion posicion);

    void pasarTurno();
}
