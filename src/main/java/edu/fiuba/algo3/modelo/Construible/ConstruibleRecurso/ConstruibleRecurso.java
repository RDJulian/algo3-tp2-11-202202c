package edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;

public interface ConstruibleRecurso {
    boolean visitar(GasVespeno gasVespeno);

    boolean visitar(Mineral mineral);

    boolean visitar(RecursoNull recursoNull);
}
