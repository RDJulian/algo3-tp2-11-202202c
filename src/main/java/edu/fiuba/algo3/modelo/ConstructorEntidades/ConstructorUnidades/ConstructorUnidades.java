package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public abstract class ConstructorUnidades {
    protected ConstruibleEstructura construibleEstructura;
    protected int costoMineral;
    protected int costoGas;
    protected int costoSuministro;

    public abstract Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa);
}
