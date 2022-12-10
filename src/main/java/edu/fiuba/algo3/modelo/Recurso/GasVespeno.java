package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class GasVespeno extends Recurso {
    public GasVespeno() {
        this.unidades = 5000;
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
            raza.recolectarGas(unidades);
        }
    }

    @Override
    public boolean construible(ConstruibleRecurso construibleRecurso) {
        return construibleRecurso.visitar(this);
    }
}
