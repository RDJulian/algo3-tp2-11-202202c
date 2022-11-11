package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class GasVespeno extends Recurso {
    public GasVespeno() {
        this.unidades = 5000;
    }

    @Override
    public void construible(ConstruibleSobreRecurso sobreRecurso) {
        sobreRecurso.construirEnGas();
    }

    @Override
    public void extraerRecurso(int unidades, Reserva reserva) {
        this.unidades -= unidades;
        reserva.agregarRecurso(unidades);
    }
}
