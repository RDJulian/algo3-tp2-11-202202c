package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class ConstructorZangano extends ConstructorUnidades {
    public ConstructorZangano(ArrayList<Estructura> estructuras, Raza raza) {
        super(estructuras, raza);
    }

    public Unidad construir(Posicion posicion) {
        return new Zangano(posicion, raza, estructuras);
    }
}
