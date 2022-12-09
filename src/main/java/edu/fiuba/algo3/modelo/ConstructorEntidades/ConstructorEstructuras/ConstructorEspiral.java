package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

import java.util.ArrayList;

public class ConstructorEspiral extends ConstructorEstructuras {
    public ConstructorEspiral(ArrayList<Estructura> estructuras, Raza raza) {
        super(estructuras, raza);
    }

    @Override
    public Estructura construir(Posicion posicion, Recurso recurso) {
        return new Espiral(posicion, raza, recurso, estructuras);
    }
}