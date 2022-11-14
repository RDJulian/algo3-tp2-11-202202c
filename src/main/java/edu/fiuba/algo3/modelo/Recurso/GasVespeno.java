package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class GasVespeno extends Recurso {
    public GasVespeno() {
        this.unidades = 5000;
    }

    public GasVespeno(Posicion posicion) {
        super(posicion);
        this.unidades = 5000;
    }

    @Override
    public void construible(ConstruibleSobreRecurso sobreRecurso) {
        sobreRecurso.construirEnGas();
    }
}
