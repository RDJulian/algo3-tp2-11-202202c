package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Recurso.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Zangano extends Unidad implements ExtraeRecurso {

    public Zangano() {
        this.danioTierra = 0;
    }

    public void usarExtractor(Recurso recurso, Reserva reserva, ExtraeRecurso extractor) {
        recurso.extraerRecurso(10, reserva, extractor);
    }

    public void extraerRecurso(Recurso recurso, Reserva reserva) {
        recurso.extraerRecurso(10, reserva, this);
    }

    public void ocupar(Recurso mineral) { // No parece una buena solucion
        mineral.ocupable(this);
    }

    @Override
    public void setReserva(Reserva reserva) { // Puede servir

    }
}
