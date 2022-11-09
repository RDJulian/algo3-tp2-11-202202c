package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;

public class Asimilador extends Estructura {

    public Asimilador(Posicion posicion) {
        super(posicion);
        this.tiempoConstruccionRestante = 6;
    }

    @Override
    public void pasarTurnoOperativo() {

    }

    @Override
    public void construirEnGasVespeno(GasVespeno gasVespeno) {

    }
}
