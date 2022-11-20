package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Mineral extends Recurso {
    public Mineral() {
        this.unidades = 2000;
    }

    public Mineral(Posicion posicion) {
        super(posicion);
        this.unidades = 2000;
    }

    @Override
    public void construible(Construible sobreRecurso) {
        sobreRecurso.manejar(GasVespeno.class);
    }
}
