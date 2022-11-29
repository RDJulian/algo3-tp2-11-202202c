package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Destruido;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;

public abstract class Unidad extends Entidad {
    //Ver que hacer con esto, no todos implementan
    protected TipoUnidad tipoUnidad;
    protected int danioTierra;
    protected int danioAire;
    protected int rangoAtaque;
    protected boolean invisible;
    protected int contadorDeBajas;


    //Segregar en una interfaz Atacante.
    public void atacar(Entidad entidad) {
        estadoEntidad.operable();
        entidad.daniar(danioTierra, danioAire, posicion, rangoAtaque, this);
    }

    @Override
    public void daniar(int danioTierra, int danioAire, Posicion posicionAtacante, int rangoAtaque, Unidad unidadAtacante) {
        estadoEntidad.atacable();
        if (!posicion.enRango(posicionAtacante, rangoAtaque) || invisible) {
            throw new AtaqueNoValidoException();
        }
        int danioARecibir = tipoUnidad.recibirDanio(danioAire, danioTierra);
        defensa.proteger(this, this.vida, danioARecibir, unidadAtacante);
    }

    //Deberia ser private.
    public void moverse(Posicion posicion) {
        this.posicion = posicion;
    }

    public void moverse(Area area) {
        estadoEntidad.operable();
        area.mover(this, tipoUnidad);
    }

    public void sumarBaja() {
        contadorDeBajas = contadorDeBajas + 1;
    }

    @Override
    public void destruir() {
        this.estadoEntidad = new Destruido();
        this.rolEnSuministro = new Neutral();
        raza.destruirEntidad(this);
    }
}
