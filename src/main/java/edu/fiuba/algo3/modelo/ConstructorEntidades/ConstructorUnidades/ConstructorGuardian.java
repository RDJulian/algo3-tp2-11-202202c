package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.NoRequiereEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorGuardian extends ConstructorUnidades {
    public ConstructorGuardian() {
        this.construibleEstructura = new NoRequiereEstructura();
        this.costoMineral = 50;
        this.costoGas = 100;
        this.costoSuministro = 4;
    }

    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa) {
        construibleEstructura.visitar(estructuraCorrelativa);
        raza.construible(costoMineral, costoGas, costoSuministro);

        raza.gastarRecursos(costoMineral, costoGas);
        Unidad unidad = new Guardian(posicion, raza);
        raza.registarEntidad(unidad);
        return unidad;
    }
}
