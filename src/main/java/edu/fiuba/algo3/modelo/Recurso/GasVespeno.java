package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;

public class GasVespeno extends Recurso {
    public GasVespeno() {
        this.unidades = 5000;
    }

    @Override
    public void construible(ConstruibleSobreRecurso sobreRecurso) {
        sobreRecurso.construirEnGas();
    }

    @Override
    public void extraerRecurso(int unidades, ReservaGas reservaGas) {
        this.unidades -= unidades;
        reservaGas.agregarRecurso(unidades);
    }
}
