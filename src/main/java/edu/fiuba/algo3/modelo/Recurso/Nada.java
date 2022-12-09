package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class Nada extends Recurso {
    @Override
    public boolean construible(ConstruibleRecurso construibleRecurso, Posicion posicion) {
        return construibleRecurso.visitar(this) && posicion.es(this.posicion);
    }

    @Override
    public void extraerRecurso(int unidades, Raza raza, ExtraeRecurso extraeRecurso) {
    }
}
