package edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

import java.util.ArrayList;

public abstract class ConstruibleRecurso {
    public boolean construible(Recurso recurso, Posicion posicion) {
        return recurso.construible(this, posicion);
    }

    public abstract boolean visitar(GasVespeno gasVespeno);

    public abstract boolean visitar(Mineral mineral);

    public abstract boolean visitar(Nada nada);
}
