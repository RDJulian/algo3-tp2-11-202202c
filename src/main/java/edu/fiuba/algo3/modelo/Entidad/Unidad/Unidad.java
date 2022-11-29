package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class Unidad extends Entidad {
    //Ver que hacer con esto, no todos implementan
    protected TipoUnidad tipoUnidad;
    protected int danioTierra;
    protected int danioAire;
    protected int rangoAtaque;
    protected boolean invisible;


    //Segregar en una interfaz Atacante.
    public void atacar(Entidad entidad) {
        estadoEntidad.operable();
        entidad.daniar(danioTierra, danioAire, posicion, rangoAtaque);
    }

    @Override
    public void daniar(int danioTierra, int danioAire, Posicion posicionAtacante, int rangoAtaque) {
        estadoEntidad.atacable();
        if (!posicion.enRango(posicionAtacante, rangoAtaque)) {
            throw new AtaqueNoValidoException();
        }
        int danioARecibir = tipoUnidad.recibirDanio(danioAire, danioTierra);
        defensa.proteger(this, vida, danioARecibir);
    }

    public void moverse(Posicion posicion) {
        this.posicion = posicion;
    }

    public void moverse(Area area) {
        estadoEntidad.operable();
        area.mover(this, tipoUnidad);
    }

    @Override
    public void daniar(int danioTierra, int danioAire, Rango rango, Zealot unidadAtacante) {
        this.estadoEntidad.atacable();
        if (rangoAtaque.noIncluye(this.posicion) || (this.invisible)) {
            throw new AtaqueNoValidoException();
        }
        int danioARecibir = this.tipoUnidad.recibirDanio(danioAire, danioTierra);
        this.defensa.proteger(this, this.vida, danioARecibir, unidadAtacante);
    }
}
