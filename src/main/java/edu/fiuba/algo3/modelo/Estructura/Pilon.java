package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;

public class Pilon extends Estructura {
    private Rango rango;

    public Pilon(Posicion posicion) {
        super(posicion);
        this.rango = new Rango(posicion, 3);
    }

    @Override
    public void pasarTurnoOperativo() {

    }

    @Override
    public void construirEnGasVespeno(GasVespeno gasVespeno) {

    }

    public void enRango(Posicion posicion) {
        this.rango.incluye(posicion);
    }
}
