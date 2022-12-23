package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;

import java.util.ArrayList;

public class ConstructorAcceso extends ConstructorEstructuras {
    private Protoss protoss;

    public ConstructorAcceso(ArrayList<Estructura> estructuras, Protoss protoss) {
        super(estructuras);
        this.protoss = protoss;
    }

    @Override
    public Estructura construir(Area area) {
        return new Acceso(area, protoss);
    }
}