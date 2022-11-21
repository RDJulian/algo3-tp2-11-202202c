package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;

public class Moho implements Piso {
    private int turnos;
    private Rango rango;

    public Moho(Posicion posicion) {
        this.rango = new Rango(posicion, 5);
        this.turnos = 0;
    }

    public boolean fueraDeRango(Posicion posicion) {
        return this.rango.noIncluye(posicion);
    }

    @Override
    public void construible(Construible sobreRango, Posicion posicion) {
        sobreRango.manejar(Moho.class);
        if (fueraDeRango(posicion)) {
            throw new ConstruccionNoValidaException();
        }
    }

    public void pasarTurno() {
        this.turnos += 1;
        if (this.turnos % 2 == 0) {
            this.rango.expandir();
        }
    }

    public void expandible(Posicion posicion) {
        posicion.ocupable();
    }
}
