package edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class Ataque {
    protected Unidad unidadAtacante;
    protected Posicion posicionAtacante;
    protected int danioTierra;
    protected int danioAire;
    protected int rangoAtaque;

    public abstract int calcularDanio(TipoUnidad tipoUnidad, Posicion posicionObjetivo);

    public abstract void atacar(Entidad entidad, Posicion posicionAtacante);
}
