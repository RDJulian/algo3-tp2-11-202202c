package edu.fiuba.algo3.modelo.Posicion.Area;

import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;

public abstract class Area {
    public abstract void movible(TipoUnidad tipoUnidad);
}