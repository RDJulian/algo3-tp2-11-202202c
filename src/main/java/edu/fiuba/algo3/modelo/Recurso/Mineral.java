package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;

public class Mineral extends Recurso {
    public Mineral() {
        this.unidades = 5000;
    }

    @Override
    public void construible(ConstruibleSobreRecurso sobreRecurso) {
        sobreRecurso.construirEnMineral();
    }

    @Override
    public void extraerRecurso(int unidades, ReservaGas reservaGas) {
        
    }
}
