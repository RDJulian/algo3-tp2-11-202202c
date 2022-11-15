package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoOperativo;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Unidad {
    protected Vida vida;

    protected Defensa defensa;
    protected TipoUnidad tipoUnidad;

    protected EstadoOperativo estadoOperativo;

    protected int danioTierra;
    protected int danioAire;

    public void atacarEstructura(Estructura estructura) {
        estructura.daniar(this.danioTierra);
    }

    public void atacarUnidad(Unidad otraUnidad) {
        otraUnidad.daniar(danioAire, danioTierra);
    }

    //Deberia ser privado.
    private void daniar(int danioAire, int danioTierra) {
        this.estadoOperativo.atacable();
        int danioARecibir = this.tipoUnidad.recibirDanio(danioAire, danioTierra);
        this.defensa.proteger(this, this.vida, danioARecibir);
    }

    public void setEstadoOperativo(EstadoOperativo estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }
}
