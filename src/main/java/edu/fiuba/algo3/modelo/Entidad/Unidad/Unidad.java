package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.Daniable;
import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Unidad implements Daniable {
    protected Vida vida;
    protected Defensa defensa;
    protected TipoUnidad tipoUnidad;
    protected EstadoEntidad estadoEstructura;
    protected int danioTierra;
    protected int danioAire;

    //Por el momento una sola unidad no ataca, porque no tiene danio. Ademas, solo las Unidades atacan.
    //No amerita segregar la interfaz, se hace override de este metodo y directamente se lanza excepcion.
    public void atacar(Daniable daniable) {
        daniable.daniar(this.danioTierra, this.danioAire);
    }

    @Override
    public void daniar(int danioTierra, int danioAire) {
        this.estadoEstructura.atacable();
        int danioARecibir = this.tipoUnidad.recibirDanio(danioAire, danioTierra);
        this.defensa.proteger(this, this.vida, danioARecibir);
    }

    public void setEstado(EstadoEntidad estadoEstructura) {
        this.estadoEstructura = estadoEstructura;
    }
}
