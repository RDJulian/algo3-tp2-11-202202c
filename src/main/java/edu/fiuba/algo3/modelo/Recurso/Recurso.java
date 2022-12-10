package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

public abstract class Recurso {
    protected int unidades;

    public abstract boolean construible(ConstruibleRecurso sobreRecurso);

    public abstract void extraerRecurso(int unidades, Raza raza);
}
