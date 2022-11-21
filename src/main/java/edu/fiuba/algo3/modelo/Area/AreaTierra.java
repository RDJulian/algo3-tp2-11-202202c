package edu.fiuba.algo3.modelo.Area;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class AreaTierra extends Area {
    public AreaTierra(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void mover(Unidad unidad, TipoUnidad tipoUnidad) {
        tipoUnidad.manejar(AreaTierra.class);
        unidad.moverse(posicion);
    }
}
