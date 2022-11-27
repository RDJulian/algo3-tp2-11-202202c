package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereCriadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorZangano extends ConstructorUnidades {
    public ConstructorZangano() {
        this.construibleEstructura = new RequiereCriadero();
        this.costoMineral = 25;
        this.costoGas = 0;
        this.costoSuministro = 1;
    }

    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa) {
        construibleEstructura.visitar(estructuraCorrelativa);
        raza.construible(costoMineral, costoGas, costoSuministro);

        raza.gastarRecursos(costoMineral, costoGas);
        Unidad unidad = new Zangano(posicion, raza);
        raza.registarEntidad(unidad);
        return unidad;
    }
}
