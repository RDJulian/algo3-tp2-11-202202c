package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Destruido;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.RolEnSuministro.RolEnSuministro;

public abstract class Unidad extends Entidad {
    protected TipoUnidad tipoUnidad;
    protected boolean invisible;

    public void atacar(Entidad entidad) {
        throw new AtaqueNoValidoException();
    }

    @Override
    public void daniar(int danioTierra, int danioAire, Posicion posicionAtacante, int rangoAtaque, UnidadAtacante unidadAtacante) {
        estadoEntidad.atacable();
        if (!posicion.enRango(posicionAtacante, rangoAtaque) || invisible) {
            throw new AtaqueNoValidoException();
        }
        int danioARecibir = tipoUnidad.recibirDanio(danioAire, danioTierra);
        defensa.proteger(this, this.vida, danioARecibir, unidadAtacante);
    }

    public void moverse(Posicion posicion) {
        this.posicion = posicion;
    }

    public void moverse(Area area) {
        estadoEntidad.operable();
        area.mover(this, tipoUnidad);
    }

    @Override
    public int afectarSuministro(int suministro) {
        return rolEnSuministro.afectarSuministro(suministro);
    }
}
