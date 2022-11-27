package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.NoRequiereEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorAmoSupremo extends ConstructorUnidades {
    //Suponemos que el AmoSupremo se construye sin ninguna Estructura, pero deberia igual requerir un criadero
    //para tener larvas.
    public ConstructorAmoSupremo() {
        this.construibleEstructura = new NoRequiereEstructura();
        this.costoMineral = 50;
        this.costoGas = 0;
        this.costoSuministro = 0;
    }

    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa) {
        construibleEstructura.visitar(estructuraCorrelativa);
        raza.construible(costoMineral, costoGas, costoSuministro);

        raza.gastarRecursos(costoMineral, costoGas);
        Unidad unidad = new AmoSupremo(posicion);
        raza.registarEntidad(unidad);
        return unidad;
    }
}
