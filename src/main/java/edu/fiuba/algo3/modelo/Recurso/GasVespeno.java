package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;

public class GasVespeno extends Recurso {
    public GasVespeno() {
        this.unidades = 5000;
    }

    @Override
    public void construible(ConstruibleSobreRecurso sobreRecurso) {
        sobreRecurso.construirEnGas();
    }
}
