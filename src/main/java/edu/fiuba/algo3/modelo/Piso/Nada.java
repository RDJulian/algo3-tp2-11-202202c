package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRango;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Nada implements Piso {
    @Override
    public boolean fueraDeRango(Posicion posicion) {
        return false;
    }

    @Override
    public void construible(ConstruibleSobreRango sobreRango, Posicion posicion) {
        sobreRango.manejar(Nada.class);
    }

    @Override
    public void pasarTurno() {
    }
}
