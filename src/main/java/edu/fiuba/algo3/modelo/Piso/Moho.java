package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRango;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
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
    public void construible(ConstruibleSobreRango sobreRango) {
        sobreRango.construirEnMoho();
    }

    public void pasarTurno() {
        this.turnos += 1;
        if (this.turnos % 2 == 0) {
            this.rango.expandir();
        }
    }

    public void expandibleSobre(Posicion posicion) {
        posicion.ocupable();
    }

    public void expandibleSobre(Estructura estructura) {
        estructura.expandible(this);
    }

}
