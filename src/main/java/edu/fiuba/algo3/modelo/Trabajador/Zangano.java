package edu.fiuba.algo3.modelo.Trabajador;

import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;

public class Zangano {
    private ReservaGas reservaGas;

    public Zangano(ReservaGas reservaGas){
        this.reservaGas = reservaGas;
    }

    public void extraerGas(GasVespeno gasVespeno) {
        gasVespeno.extraerGas(10, reservaGas);
    }
}
