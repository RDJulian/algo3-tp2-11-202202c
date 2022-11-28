package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Daniable;
import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Unidad implements Daniable {
    protected Vida vida;
    protected Defensa defensa;
    protected TipoUnidad tipoUnidad;
    protected EstadoEntidad estadoEntidad;
    protected int danioTierra;
    protected int danioAire;
    protected Posicion posicion;
    protected Rango rangoAtaque;
    protected int radioAtaque;
    protected boolean invisible;

    public Unidad(Posicion posicion) {
        this.posicion = posicion;
    }

    public void operable() {
        this.estadoEntidad.operable();
    }

    public void pasarTurno() {
        this.estadoEntidad.pasarTurno(this, this.vida, this.defensa);
    }

    //Por el momento una sola unidad no ataca, porque no tiene danio. Ademas, solo las Unidades atacan.
    //No amerita segregar la interfaz, se hace override de este metodo y directamente se lanza excepcion.
    public void atacar(Daniable daniable) {
        this.estadoEntidad.operable();
        daniable.daniar(this.danioTierra, this.danioAire, this.rangoAtaque);
    }

    @Override
    public void daniar(int danioTierra, int danioAire, Rango rangoAtaque) {
        this.estadoEntidad.atacable();
        if (rangoAtaque.noIncluye(this.posicion) || (this.invisible)) {
            throw new AtaqueNoValidoException();
        }
        int danioARecibir = this.tipoUnidad.recibirDanio(danioAire, danioTierra);
        this.defensa.proteger(this, this.vida, danioARecibir);
    }

    public void moverse(Posicion posicion) {
        this.posicion = posicion;
        this.rangoAtaque = new Rango(posicion, this.radioAtaque);
    }

    public void moverse(Area area) {
        this.estadoEntidad.operable();
        area.mover(this, this.tipoUnidad);
    }

    public void setEstado(EstadoEntidad estadoEstructura) {
        this.estadoEntidad = estadoEstructura;
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
