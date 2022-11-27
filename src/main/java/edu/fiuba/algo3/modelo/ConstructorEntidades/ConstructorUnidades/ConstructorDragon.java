package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereAcceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Dragon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorDragon extends ConstructorUnidades {
    public ConstructorDragon() {
        this.construibleEstructura = new RequiereAcceso();
        this.costoMineral = 125;
        this.costoGas = 50;
        this.costoSuministro = 3;
    }

    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa) {
        construibleEstructura.visitar(estructuraCorrelativa);
        raza.construible(costoMineral, costoGas, costoSuministro);

        raza.gastarRecursos(costoMineral, costoGas);
        Unidad unidad = new Dragon(posicion);
        raza.registarEntidad(unidad);
        return unidad;
    }
}
