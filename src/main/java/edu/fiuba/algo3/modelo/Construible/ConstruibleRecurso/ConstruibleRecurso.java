package edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.RecursoNull;

public abstract class ConstruibleRecurso {
    public boolean construible(Area area) {
        return area.construible(this);
    }

    public abstract boolean visitar(GasVespeno gasVespeno);

    public abstract boolean visitar(Mineral mineral);

    public abstract boolean visitar(RecursoNull recursoNull);
}
