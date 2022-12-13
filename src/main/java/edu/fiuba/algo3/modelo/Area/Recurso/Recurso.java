package edu.fiuba.algo3.modelo.Area.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Raza.Raza;

public abstract class Recurso {
    protected int unidades;

    public abstract boolean construible(ConstruibleRecurso construibleRecurso);

    public abstract void extraerRecurso(int unidades, Raza raza);

    public abstract boolean visitar(Unidad unidad);

    public abstract boolean visitar(Zangano unidad);
}
