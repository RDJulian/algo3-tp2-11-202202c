package edu.fiuba.algo3.modelo.Area.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class RecursoNull extends Recurso {
    @Override
    public boolean construible(ConstruibleRecurso construibleRecurso) {
        return construibleRecurso.visitar(this);
    }

    @Override
    public void extraerRecurso(int unidades, Raza raza) {
    }
}
