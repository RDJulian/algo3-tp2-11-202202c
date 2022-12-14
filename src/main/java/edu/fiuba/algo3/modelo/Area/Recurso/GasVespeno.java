package edu.fiuba.algo3.modelo.Area.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class GasVespeno extends Recurso {
    public GasVespeno() {
        this.unidades = 5000;
        this.nombre = "gas";
    }

    public GasVespeno(int unidades) {
        this.unidades = unidades;
        this.nombre = "gas";
    }

    //Codigo muy similar.
    public void extraerRecurso(int unidades, Raza raza) {
        if (this.unidades == 0) {
            throw new RecursoVacioException();
        } else if (this.unidades < unidades) {
            raza.recolectarGas(this.unidades);
            this.unidades = 0;
        } else {
            this.unidades -= unidades;
            raza.recolectarGas(unidades);
        }
    }

    @Override
    public boolean visitar(Unidad unidad) {
        return false;
    }

    @Override
    public boolean visitar(Zangano unidad) {
        return false;
    }

    @Override
    public boolean construible(ConstruibleRecurso construibleRecurso) {
        return construibleRecurso.visitar(this);
    }
}
