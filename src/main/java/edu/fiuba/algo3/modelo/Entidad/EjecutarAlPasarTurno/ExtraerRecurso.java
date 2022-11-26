package edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno;

import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;

public class ExtraerRecurso implements Ejecutar {
    private ExtraeRecurso entidad;

    public ExtraerRecurso(ExtraeRecurso entidad) {
        this.entidad = entidad;
    }

    @Override
    public void ejecutar() {
        entidad.extraerRecurso();
    }
}
