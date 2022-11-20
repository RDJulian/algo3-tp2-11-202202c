package edu.fiuba.algo3.modelo.Area;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.TipoUnidad;

public class AreaEspacial implements Area {
    @Override
    public void movible(TipoUnidad tipoUnidad) {
        tipoUnidad.manejar(AreaEspacial.class);
    }
}
