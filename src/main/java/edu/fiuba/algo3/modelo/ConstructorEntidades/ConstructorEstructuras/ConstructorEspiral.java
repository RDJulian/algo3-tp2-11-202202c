package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class ConstructorEspiral extends ConstructorEstructuras {
    private Zerg zerg;

    public ConstructorEspiral(ArrayList<Estructura> estructuras, Zerg zerg) {
        super(estructuras);
        this.zerg = zerg;
    }

    @Override
    public Estructura construir(Area area) {
        return new Espiral(area, zerg, estructuras);
    }
}