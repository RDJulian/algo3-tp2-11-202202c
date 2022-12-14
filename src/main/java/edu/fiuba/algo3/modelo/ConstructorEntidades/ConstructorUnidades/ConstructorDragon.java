package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Dragon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;

import java.util.ArrayList;

public class ConstructorDragon extends ConstructorUnidades {
    private Protoss protoss;

    public ConstructorDragon(ArrayList<Estructura> estructuras, Protoss protoss) {
        super(estructuras);
        this.protoss = protoss;
    }

    public Unidad construir(Area area) {
        return new Dragon(area, estructuras, protoss);
    }
}
