package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Guarida;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class ConstructorGuarida extends ConstructorEstructuras {
    private Zerg zerg;

    public ConstructorGuarida(ArrayList<Estructura> estructuras, Zerg zerg) {
        super(estructuras);
        this.zerg = zerg;
    }

    @Override
    public Estructura construir(Area area) {
        return new Guarida(area, zerg, estructuras);
    }
}