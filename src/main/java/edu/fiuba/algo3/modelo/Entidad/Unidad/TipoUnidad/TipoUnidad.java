package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Posicion.Area.AreaEspacial;
import edu.fiuba.algo3.modelo.Posicion.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class TipoUnidad {
    public Posicion movible(Posicion posicion) {
        return posicion;
    }

    public abstract Posicion movible(AreaEspacial area, Posicion posicion);

    public abstract int recibirDanio(int danioAire, int danioTierra);
}
