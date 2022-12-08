package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class UsarExtractor implements Comando {
    private Recurso recurso;
    private Raza raza;
    private ExtraeRecurso extractor;

    public UsarExtractor(Recurso recurso, Raza raza, ExtraeRecurso extractor) {
        this.recurso = recurso;
        this.raza = raza;
        this.extractor = extractor;
    }

    @Override
    public void ejecutar() {
        recurso.extraerRecurso(10, raza, extractor);
    }
}
