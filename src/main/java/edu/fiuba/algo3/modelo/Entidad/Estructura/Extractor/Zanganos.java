package edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLlenoException;

import java.util.ArrayList;

public class Zanganos implements AgregaZanganos {
    private ArrayList<Zangano> zanganos;

    public Zanganos() {
        this.zanganos = new ArrayList<>();
    }

    public void extraerRecurso(Area area) {
        for (Zangano zangano : zanganos) {
            zangano.usarExtractor(area);
        }
    }

    @Override
    public void agregarZangano(Zangano zangano) {
        if (zanganos.size() >= 3) {
            throw new ExtractorLlenoException();
        }
        zanganos.add(zangano);
    }

    @Override
    public void quitarZangano(Zangano zangano) {
        zanganos.remove(zangano);
    }
}
