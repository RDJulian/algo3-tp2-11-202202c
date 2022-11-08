package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;

public class GasVespeno {

    private Integer unidades;

    public GasVespeno() {
        this.unidades = 5000;
    }

    public void agregarRefineria(Estructura estructura) {
        estructura.construirEnGasVespeno(this);
    }

    public void extraerGas(int unidades, ReservaGas reservaGas) {
        this.unidades -= unidades;
        reservaGas.agregarRecurso(unidades);
    }
}
