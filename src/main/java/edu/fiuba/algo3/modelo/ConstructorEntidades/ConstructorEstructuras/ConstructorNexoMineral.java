package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;

import java.util.ArrayList;

public class ConstructorNexoMineral extends ConstructorEstructuras {
    private Protoss protoss;

    public ConstructorNexoMineral(ArrayList<Estructura> estructuras, Protoss protoss) {
        super(estructuras);
        this.protoss = protoss;
    }

    @Override
    public Estructura construir(Area area) {
        return new NexoMineral(area, protoss);
    }
}