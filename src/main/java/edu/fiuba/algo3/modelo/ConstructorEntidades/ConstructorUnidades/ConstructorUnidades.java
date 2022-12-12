package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public abstract class ConstructorUnidades {
    //Factory Method.
    protected ArrayList<Estructura> estructuras;
    protected Raza raza;

    public ConstructorUnidades(ArrayList<Estructura> estructuras, Raza raza) {
        this.estructuras = estructuras;
        this.raza = raza;
    }

    public abstract Unidad construir(Area area);
}
