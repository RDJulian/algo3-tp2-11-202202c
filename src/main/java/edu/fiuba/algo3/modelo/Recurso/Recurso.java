package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.PosicionIncorrectaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;

public abstract class Recurso {
    //Estaria bueno probar que una estructura solo puede construirse si ademas esta en la
    //posicion del recurso.
    protected int unidades;
    protected Posicion posicion;
    protected ExtraeRecurso extraeRecurso;

    public abstract void construible(ConstruibleRecurso sobreRecurso, Posicion posicion);

    //La desventaja de tener las reservas en Raza es que se termina con codigo muy similar.
    public abstract void extraerRecurso(int unidades, Raza raza, ExtraeRecurso extraeRecurso);

    //Ver si hay mejor solucion para los dos metodos.
    public void ocupar(ExtraeRecurso extraeRecurso) {
        this.extraeRecurso = extraeRecurso;
    }

    public void ocupar(Zangano zangano, Posicion posicion) {
        if (!this.posicion.es(posicion)) {
            throw new PosicionIncorrectaException();
        }
        this.posicion.ocupable();
        this.extraeRecurso = zangano;
        this.posicion.ocupar();
    }
}
