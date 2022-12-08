package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class OcuparMineral implements Comando {
    private ExtraeRecurso extraeRecurso;
    private Recurso mineral;
    private Posicion posicion;

    public OcuparMineral(ExtraeRecurso extraeRecurso, Recurso mineral, Posicion posicion) {
        this.extraeRecurso = extraeRecurso;
        this.mineral = mineral;
        this.posicion = posicion;
    }

    @Override
    public void ejecutar() {
        mineral.ocupar(extraeRecurso, posicion);
    }
}
