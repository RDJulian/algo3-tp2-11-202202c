package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRango;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Nada implements Piso {
    @Override
    public boolean fueraDeRango(Posicion posicion) { //Tener cuidado con esto.
        return false;
    }

    @Override
    public void construible(ConstruibleSobreRango sobreRango) {

    }

    @Override
    public void pasarTurno() {

    }
}
