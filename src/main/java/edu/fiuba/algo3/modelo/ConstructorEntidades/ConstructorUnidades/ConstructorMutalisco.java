package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereEspiral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Mutalisco;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorMutalisco extends ConstructorUnidades {
    public ConstructorMutalisco() {
        this.construibleEstructura = new RequiereEspiral();
        this.costoMineral = 100;
        this.costoGas = 100;
        this.costoSuministro = 4;
    }

    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa) {
        construibleEstructura.visitar(estructuraCorrelativa);
        raza.construible(costoMineral, costoGas, costoSuministro);

        raza.gastarRecursos(costoMineral, costoGas);
        Unidad unidad = new Mutalisco(posicion, raza);
        raza.registarEntidad(unidad);
        return unidad;
    }
}
