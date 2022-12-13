package edu.fiuba.algo3.modelo.Area.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class RecursoNull extends Recurso {
    @Override
    public boolean construible(ConstruibleRecurso construibleRecurso) {
        return construibleRecurso.visitar(this);
    }

    @Override
    public void extraerRecurso(int unidades, Raza raza) {
        //Nada.
    }

    @Override
    public boolean visitar(Unidad unidad) {
        return true;
    }

    @Override
    public boolean visitar(Zangano unidad) {
        return true;
    }
}
