package edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor;

import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLlenoException;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

import java.util.ArrayList;

public class Zanganos {
    private ArrayList<Zangano> zanganos;

    public Zanganos() {
        this.zanganos = new ArrayList<>();
    }

    public void extraerRecurso(Recurso gasVespeno, Extractor extractor) {
        for (Zangano zangano : zanganos) {
            zangano.usarExtractor(gasVespeno, extractor);
        }
    }

    public void agregarZangano(Zangano zangano) {
        if (zanganos.size() >= 3) {
            throw new ExtractorLlenoException();
        }
        zanganos.add(zangano);
    }
}
