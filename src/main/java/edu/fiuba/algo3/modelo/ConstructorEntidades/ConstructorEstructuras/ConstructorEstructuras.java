package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public abstract class ConstructorEstructuras {
    //Factory Method.
    protected ArrayList<Estructura> estructuras;
    protected Raza raza;

    public ConstructorEstructuras(ArrayList<Estructura> estructuras, Raza raza) {
        this.estructuras = estructuras;
        this.raza = raza;
    }

    public abstract Estructura construir(Area area);
}