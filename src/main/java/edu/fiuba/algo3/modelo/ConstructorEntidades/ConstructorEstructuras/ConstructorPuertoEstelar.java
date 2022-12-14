package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;

import java.util.ArrayList;

public class ConstructorPuertoEstelar extends ConstructorEstructuras {
    private Protoss protoss;

    public ConstructorPuertoEstelar(ArrayList<Estructura> estructuras, Protoss protoss) {
        super(estructuras);
        this.protoss = protoss;
    }

    @Override
    public Estructura construir(Area area) {
        return new PuertoEstelar(area, protoss, estructuras);
    }
}