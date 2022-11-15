package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Estructura.Estructura;

public abstract class Unidad {
    protected int danioTierra;

    public void atacarEstructura(Estructura estructura) {
        estructura.daniar(this.danioTierra);
    }

}
