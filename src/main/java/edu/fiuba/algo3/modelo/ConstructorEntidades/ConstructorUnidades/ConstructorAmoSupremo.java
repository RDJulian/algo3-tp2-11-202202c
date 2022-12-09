package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

import java.util.ArrayList;

public class ConstructorAmoSupremo extends ConstructorUnidades {
    //Suponemos que el AmoSupremo se construye sin ninguna Estructura, pero deberia igual requerir un criadero
    //para tener larvas.
    public ConstructorAmoSupremo(ArrayList<Estructura> estructuras, Raza raza) {
        super(estructuras, raza);
    }

    public Unidad construir(Posicion posicion) {
        return new AmoSupremo(posicion, raza);
    }
}
