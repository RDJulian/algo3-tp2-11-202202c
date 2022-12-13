package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class ConstructorAsimilador extends ConstructorEstructuras {
    private Protoss protoss;

    public ConstructorAsimilador(ArrayList<Estructura> estructuras, Protoss protoss) {
        super(estructuras);
        this.protoss = protoss;
    }

    @Override
    public Estructura construir(Area area) {
        return new Asimilador(area, protoss);
    }
}