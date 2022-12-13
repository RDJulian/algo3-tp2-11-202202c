package edu.fiuba.algo3.modelo.Area.TipoArea;

import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Area.Area;

public class AreaEspacial implements TipoArea {
    @Override
    public Area moverse(TipoUnidad tipoUnidad, Area area) {
        return tipoUnidad.moverse(this, area);
    }

    @Override
    public boolean construible() {
        return false;
    }
}
