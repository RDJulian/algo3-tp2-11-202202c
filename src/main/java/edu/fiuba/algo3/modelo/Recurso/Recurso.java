package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacio;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public abstract class Recurso {
    protected int unidades;

    public abstract void construible(ConstruibleSobreRecurso sobreRecurso);

    public void extraerRecurso(int unidades, Reserva reserva) {
        int nuevasUnidades = this.unidades - unidades;
        if (nuevasUnidades < 0) {
            throw new RecursoVacio();
        }
        this.unidades = nuevasUnidades;
        reserva.agregarRecurso(unidades);
    }
}
