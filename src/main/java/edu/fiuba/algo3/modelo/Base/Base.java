package edu.fiuba.algo3.modelo.Base;

import edu.fiuba.algo3.modelo.Excepciones.BaseNoOpuestaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Base {
    //Ver como enganchar esta clase con lo demas o si siquiera deberia existir.
    private Posicion posicion;

    public Base(Posicion posicion) {
        this.posicion = posicion;
    }

    public void opuesta(Base otraBase) {
        if (!otraBase.esOpuesta(posicion)) {
            throw new BaseNoOpuestaException();
        }
    }

    private boolean esOpuesta(Posicion posicion) {
        return posicion.esOpuesta(this.posicion);
    }
}
