package edu.fiuba.algo3.modelo.Base;

import edu.fiuba.algo3.modelo.Excepciones.BaseNoOpuestaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Base {
    private Posicion posicion;

    public Base(Posicion posicion) {
        this.posicion = posicion;
    }

    public void opuesta(Base otraBase) {
        otraBase.esOpuesta(this.posicion);
    }

    private void esOpuesta(Posicion posicion) {
        if (!posicion.esOpuesta(this.posicion)) {
            throw new BaseNoOpuestaException();
        }
    }
}
