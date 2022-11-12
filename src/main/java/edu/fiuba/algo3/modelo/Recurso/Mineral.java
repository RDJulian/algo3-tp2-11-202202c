package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;

public class Mineral extends Recurso {
    public Mineral() {
        this.unidades = 2000;
    }

    @Override
    public void construible(ConstruibleSobreRecurso sobreRecurso) {
        sobreRecurso.construirEnMineral();
    }
}
