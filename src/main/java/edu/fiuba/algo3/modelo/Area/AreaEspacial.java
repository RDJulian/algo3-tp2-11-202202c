package edu.fiuba.algo3.modelo.Area;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class AreaEspacial extends Area {
    public AreaEspacial(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void mover(Unidad unidad, TipoUnidad tipoUnidad) {
        tipoUnidad.manejar(AreaEspacial.class);
        unidad.moverse(posicion);
    }
}
