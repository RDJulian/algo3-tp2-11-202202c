package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;

import java.util.ArrayList;

public abstract class ConstructorUnidades {
    //Factory Method.
    protected ArrayList<Estructura> estructuras;

    public ConstructorUnidades(ArrayList<Estructura> estructuras) {
        this.estructuras = estructuras;
    }

    public abstract Unidad construir(Area area);
}
