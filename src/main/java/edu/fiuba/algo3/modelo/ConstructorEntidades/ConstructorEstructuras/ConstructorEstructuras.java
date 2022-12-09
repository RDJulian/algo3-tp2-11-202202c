package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

import java.util.ArrayList;

public abstract class ConstructorEstructuras {
    //Factory Method.
    protected ArrayList<Estructura> estructuras;
    protected Raza raza;

    public ConstructorEstructuras(ArrayList<Estructura> estructuras, Raza raza) {
        this.estructuras = estructuras;
        this.raza = raza;
    }

    public abstract Estructura construir(Posicion posicion, Recurso recurso);
}