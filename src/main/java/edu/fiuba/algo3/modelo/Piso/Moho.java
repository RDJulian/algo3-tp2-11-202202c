package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Moho implements Piso {
    private int turnos;
    private int rango;

    private Posicion posicion;

    public Moho(Posicion posicion) {
        this.rango = 5;
        this.turnos = 0;
        this.posicion = posicion;
    }

    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, rango);
    }

    @Override
    public void construible(ConstruiblePiso sobreRango, Posicion posicion) {
        sobreRango.visitar(this);
        if (fueraDeRango(posicion)) {
            throw new ConstruccionNoValidaException();
        }
    }

    public void pasarTurno() {
        this.turnos += 1;
        if (this.turnos % 2 == 0) {
            this.rango += 1;
        }
    }

    public void expandible(Posicion posicion) {
        posicion.ocupable();
    }
}
