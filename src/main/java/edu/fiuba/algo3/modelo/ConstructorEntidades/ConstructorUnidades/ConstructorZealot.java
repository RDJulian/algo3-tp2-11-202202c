package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zealot;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class ConstructorZealot extends ConstructorUnidades {
    public ConstructorZealot(ArrayList<Estructura> estructuras, Raza raza) {
        super(estructuras, raza);
    }

    public Unidad construir(Posicion posicion) {
        return new Zealot(posicion, raza, estructuras);
    }
}
