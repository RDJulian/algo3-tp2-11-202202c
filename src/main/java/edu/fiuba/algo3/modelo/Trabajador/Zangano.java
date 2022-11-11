package edu.fiuba.algo3.modelo.Trabajador;

import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;

public class Zangano {

    public void extraerRecurso(Recurso gasVespeno, ReservaGas reservaGas) {
        gasVespeno.extraerRecurso(10, reservaGas);
    }

}
