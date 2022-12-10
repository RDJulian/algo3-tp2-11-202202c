package edu.fiuba.algo3.modelo.Area.TipoArea;

import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Area.Area;

public class AreaEspacial extends TipoArea {
    @Override
    public Area movible(TipoUnidad tipoUnidad, Area area) {
        return tipoUnidad.movible(this, area);
    }
}
