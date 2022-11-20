package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Nada implements Piso { //Se deberia usar para probar casos de fallo.
    @Override
    public boolean fueraDeRango(Posicion posicion) {
        return false;
    }

    @Override
    public void construible(Construible sobreRango, Posicion posicion) {
        sobreRango.manejar(Nada.class);
    }

    @Override
    public void pasarTurno() {
    }
}
