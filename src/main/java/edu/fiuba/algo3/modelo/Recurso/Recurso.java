package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.PosicionIncorrectaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;

public abstract class Recurso {
    protected int unidades;
    protected Posicion posicion;
    protected ExtraeRecurso extraeRecurso;

    public abstract void construible(ConstruibleRecurso sobreRecurso, Posicion posicion);

    public abstract void extraerRecurso(int unidades, Raza raza, ExtraeRecurso extraeRecurso);

    public void ocupar(ExtraeRecurso extraeRecurso, Posicion posicion) {
        if (!this.posicion.es(posicion)) {
            throw new PosicionIncorrectaException();
        }
        this.posicion.ocupar();
        this.extraeRecurso = extraeRecurso;
    }
}
