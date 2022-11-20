package edu.fiuba.algo3.modelo.Area;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.TipoUnidad;

public class AreaTierra implements Area {
    @Override
    public void movible(TipoUnidad tipoUnidad) {
        tipoUnidad.manejar(AreaTierra.class);
    }
}
