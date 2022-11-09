package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;

public class Moho {
    private Posicion posicion;

    private Rango rango;

    public Moho(Posicion posicion) {
        this.posicion = posicion;
        this.rango = new Rango(posicion, 5);
    }

    public void enRango(Posicion posicion) {
        this.rango.incluye(posicion);
    }
}
