package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Unidad implements Daniable {
    protected Vida vida;

    protected Defensa defensa;
    protected TipoUnidad tipoUnidad;

    protected EstadoEntidad estadoEstructura;

    protected int danioTierra;
    protected int danioAire;

    public void atacarEstructura(Estructura estructura) {
        estructura.daniar(this.danioTierra, this.danioAire);
    }

    public void atacarUnidad(Unidad otraUnidad) {
        otraUnidad.daniar(danioAire, danioTierra);
    }

    //Deberia ser privado.
    @Override
    public void daniar(int danioAire, int danioTierra) {
        this.estadoEstructura.atacable();
        int danioARecibir = this.tipoUnidad.recibirDanio(danioAire, danioTierra);
        this.defensa.proteger(this, this.vida, danioARecibir);
    }

    public void setEstado(EstadoEntidad estadoEstructura) {
        this.estadoEstructura = estadoEstructura;
    }
}
