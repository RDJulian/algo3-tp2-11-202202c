package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Nada implements Piso {
    @Override
    public boolean enRango(Posicion posicion) { //Tener cuidado con esto.
        return true;
    }

    @Override
    public void pasarTurno() {

    }
}
