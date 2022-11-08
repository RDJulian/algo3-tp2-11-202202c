package edu.fiuba.algo3.modelo.Trabajador;

import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;

public class Zangano {

    public void extraerGas(GasVespeno gasVespeno, ReservaGas reservaGas) {
        gasVespeno.extraerGas(10, reservaGas);
    }

}
