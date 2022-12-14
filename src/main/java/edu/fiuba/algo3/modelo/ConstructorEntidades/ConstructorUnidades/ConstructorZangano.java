package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class ConstructorZangano extends ConstructorUnidades {
    private Zerg zerg;

    public ConstructorZangano(ArrayList<Estructura> estructuras, Zerg zerg) {
        super(estructuras);
        this.zerg = zerg;
    }

    public Unidad construir(Area area) {
        return new Zangano(area, estructuras, zerg);
    }
}
