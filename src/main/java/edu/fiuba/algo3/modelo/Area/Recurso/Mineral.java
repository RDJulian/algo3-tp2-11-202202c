package edu.fiuba.algo3.modelo.Area.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class Mineral extends Recurso {
    public Mineral() {
        this.unidades = 2000;
        this.nombre = "mineral";
    }

    //Codigo muy similar.
    public void extraerRecurso(int unidades, Raza raza) {
        if (this.unidades == 0) {
            throw new RecursoVacioException();
        } else if (this.unidades < unidades) {
            raza.recolectarMineral(this.unidades);
            this.unidades = 0;
        } else {
            this.unidades -= unidades;
            raza.recolectarMineral(unidades);
        }
    }

    @Override
    public boolean visitar(Unidad unidad) {
        return false;
    }

    @Override
    public boolean visitar(Zangano unidad) {
        return true;
    }

    @Override
    public boolean construible(ConstruibleRecurso construibleRecurso) {
        return construibleRecurso.visitar(this);
    }
}
