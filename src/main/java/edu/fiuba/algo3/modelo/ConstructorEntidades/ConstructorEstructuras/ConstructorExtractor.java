package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class ConstructorExtractor extends ConstructorEstructuras {
    public ConstructorExtractor(ArrayList<Estructura> estructuras, Raza raza) {
        super(estructuras, raza);
    }

    @Override
    public Estructura construir(Area area) {
        return new Extractor(area, raza);
    }
}