package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;

public class ExtraerRecurso implements Comando {
    private ExtraeRecurso entidad;

    public ExtraerRecurso(ExtraeRecurso entidad) {
        this.entidad = entidad;
    }

    @Override
    public void ejecutar() {
        this.entidad.extraerRecurso();
    }
}
