package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.Entidad;

public abstract class UnidadAtacante extends Unidad {
    protected int danioTierra;
    protected int danioAire;
    protected int rangoAtaque;
    protected int contadorDeBajas;

    @Override
    public void atacar(Entidad entidad) {
        estadoOperativo.operable();
        entidad.daniar(danioTierra, danioAire, posicion, rangoAtaque, this);
    }

    public void sumarBaja() {
        contadorDeBajas += 1;
    }
}
