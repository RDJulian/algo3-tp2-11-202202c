package edu.fiuba.algo3.modelo.Area;

import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class Area {
    //Parece natural que un area tenga una posicion
    //Un area podria tener mas cosas, por ejemplo, un recurso, un piso, etc.
    protected Posicion posicion;

    public Area(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void mover(Unidad unidad, TipoUnidad tipoUnidad);
}
