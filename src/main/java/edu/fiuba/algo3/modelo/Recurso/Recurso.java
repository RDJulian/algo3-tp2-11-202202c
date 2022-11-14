package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;
import edu.fiuba.algo3.modelo.Estructura.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorIncorrecto;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacio;
import edu.fiuba.algo3.modelo.Posicion.Ocupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public abstract class Recurso {
    protected int unidades;
    protected Posicion posicion;
    protected ExtraeRecurso extraeRecurso;

    public Recurso() {
    }

    public Recurso(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void construible(ConstruibleSobreRecurso sobreRecurso);

    public void extraerRecurso(int unidades, Reserva reserva, ExtraeRecurso extraeRecurso) {
        if (this.extraeRecurso != extraeRecurso) {
            throw new ExtractorIncorrecto();
        }
        int nuevasUnidades = this.unidades - unidades;
        if (nuevasUnidades < 0) {
            throw new RecursoVacio();
        }
        this.unidades = nuevasUnidades;
        reserva.agregarRecurso(unidades);
    }

    public void ocupable(ExtraeRecurso extraeRecurso) {
        this.posicion.ocupable();
        posicion.setEstadoPosicion(new Ocupada());
        this.extraeRecurso = extraeRecurso;
    }
}
