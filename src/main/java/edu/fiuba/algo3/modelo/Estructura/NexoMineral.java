package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;

public class NexoMineral extends Estructura {
    public NexoMineral(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void pasarTurnoOperativo() {

    }

    @Override
    public void construirEnGasVespeno(GasVespeno gasVespeno) {

    }

    public void construir(Pilon pilon) {
        pilon.enRango(this.posicion);
    }
}
