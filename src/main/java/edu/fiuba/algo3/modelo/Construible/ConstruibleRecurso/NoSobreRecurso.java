package edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso;

import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.RecursoNull;

public class NoSobreRecurso extends ConstruibleRecurso {
    @Override
    public boolean visitar(GasVespeno gasVespeno) {
        return false;
    }

    @Override
    public boolean visitar(Mineral mineral) {
        return false;
    }

    @Override
    public boolean visitar(RecursoNull recursoNull) {
        return true;
    }
}

