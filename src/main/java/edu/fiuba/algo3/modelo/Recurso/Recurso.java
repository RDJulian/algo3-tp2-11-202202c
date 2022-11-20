package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorIncorrectoException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Posicion.Ocupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;

public abstract class Recurso {
    //Estaria bueno probar que una estructura solo puede construirse si ademas esta en la
    //posicion del recurso.
    protected int unidades;
    protected Posicion posicion;
    protected ExtraeRecurso extraeRecurso;

    public Recurso() {
    }

    public Recurso(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void construible(Construible sobreRecurso);

    public void extraerRecurso(int unidades, Reserva reserva, ExtraeRecurso extraeRecurso) {
        if (this.extraeRecurso != extraeRecurso) {
            throw new ExtractorIncorrectoException();
        }
        int nuevasUnidades = this.unidades - unidades;
        if (nuevasUnidades < 0) {
            throw new RecursoVacioException();
        }
        this.unidades = nuevasUnidades;
        reserva.agregarRecurso(unidades);
    }

    //Setter. Ver si hay mejor solucion. Revisar interfaces.
    public void ocupar(ExtraeRecurso extraeRecurso) {
        this.extraeRecurso = extraeRecurso;
    }

    public void ocupar(Zangano zangano) {
        this.posicion.ocupable();
        this.extraeRecurso = zangano;
        this.posicion.setEstadoPosicion(new Ocupada());
    }
}
