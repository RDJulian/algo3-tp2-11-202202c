package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

import java.util.ArrayList;

public class ConstructorCriadero extends ConstructorEstructuras {
    public ConstructorCriadero(ArrayList<Estructura> estructuras, Raza raza) {
        super(estructuras, raza);
    }

    @Override
    public Estructura construir(Posicion posicion, Recurso recurso) {
        return new Criadero(posicion, raza, recurso);
    }
}