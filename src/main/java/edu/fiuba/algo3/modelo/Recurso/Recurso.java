package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacio;
import edu.fiuba.algo3.modelo.Posicion.Ocupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public abstract class Recurso {
    protected int unidades;
    protected Posicion posicion;

    public Recurso() {
    }

    public Recurso(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void construible(ConstruibleSobreRecurso sobreRecurso);

    public void extraerRecurso(int unidades, Reserva reserva) {
        int nuevasUnidades = this.unidades - unidades;
        if (nuevasUnidades < 0) {
            throw new RecursoVacio();
        }
        this.unidades = nuevasUnidades;
        reserva.agregarRecurso(unidades);
    }

    public void ocupable() {
        this.posicion.ocupable();
        posicion.setEstadoPosicion(new Ocupada());
    }
}
