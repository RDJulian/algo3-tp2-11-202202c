package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.NoRequiereEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Devorador;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorDevorador extends ConstructorUnidades {
    public ConstructorDevorador() {
        this.construibleEstructura = new NoRequiereEstructura();
        this.costoMineral = 150;
        this.costoGas = 50;
        this.costoSuministro = 4;
    }

    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa) {
        construibleEstructura.visitar(estructuraCorrelativa);
        raza.construible(costoMineral, costoGas, costoSuministro);

        raza.gastarRecursos(costoMineral, costoGas);
        Unidad unidad = new Devorador(posicion);
        raza.registarEntidad(unidad);
        return unidad;
    }
}
