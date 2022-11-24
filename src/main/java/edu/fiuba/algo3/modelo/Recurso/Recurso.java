package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
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

    public abstract void construible(ConstruibleRecurso sobreRecurso);

    public abstract void extraerRecurso(int unidades, Raza raza, ExtraeRecurso extraeRecurso);

    //Setter. Ver si hay mejor solucion.
    public void ocupar(ExtraeRecurso extraeRecurso) {
        this.extraeRecurso = extraeRecurso;
    }

    public void ocupar(Zangano zangano) {
        this.posicion.ocupable();
        this.extraeRecurso = zangano;
        this.posicion.ocupar();
    }
}
