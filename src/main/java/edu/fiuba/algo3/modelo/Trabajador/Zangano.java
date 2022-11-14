package edu.fiuba.algo3.modelo.Trabajador;

import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Zangano {

    public void extraerRecurso(Recurso recurso, Reserva reserva) {
        recurso.extraerRecurso(10, reserva);
    }

    public void ocupar(Recurso mineral) {
        mineral.ocupable();
    }

}
