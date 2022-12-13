package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.AmoSupremo;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class ConstructorAmoSupremo extends ConstructorUnidades {
    private Zerg zerg;

    //Suponemos que el AmoSupremo se construye sin ninguna Estructura, pero deberia igual requerir un criadero
    //para tener larvas.
    public ConstructorAmoSupremo(ArrayList<Estructura> estructuras, Zerg zerg) {
        super(estructuras);
        this.zerg = zerg;
    }

    public Unidad construir(Area area) {
        return new AmoSupremo(area, zerg);
    }
}
