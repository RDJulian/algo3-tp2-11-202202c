package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Daniable;
import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Unidad implements Daniable {
    protected Vida vida;
    protected Defensa defensa;
    protected TipoUnidad tipoUnidad;
    protected EstadoEntidad estadoEntidad;
    protected int danioTierra;
    protected int danioAire;

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
        daniable.daniar(this.danioTierra, this.danioAire);
    }

    @Override
    public void daniar(int danioTierra, int danioAire) {
        this.estadoEntidad.atacable();
        int danioARecibir = this.tipoUnidad.recibirDanio(danioAire, danioTierra);
        this.defensa.proteger(this, this.vida, danioARecibir);
    }

    public void moverse(Area area) {
        this.estadoEntidad.operable();
        area.movible(this.tipoUnidad);
    }

    public void setEstado(EstadoEntidad estadoEstructura) {
        this.estadoEntidad = estadoEstructura;
    }
}
