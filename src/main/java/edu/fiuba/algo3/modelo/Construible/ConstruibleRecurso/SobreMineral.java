package edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso;

import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;

public class SobreMineral implements ConstruibleRecurso {
    @Override
    public boolean visitar(GasVespeno gasVespeno) {
        return false;
    }

    @Override
    public boolean visitar(Mineral mineral) {
        return true;
    }

    @Override
    public boolean visitar(RecursoNull recursoNull) {
        return false;
    }
}

