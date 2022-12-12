package edu.fiuba.algo3.modelo.Area.TipoArea;

import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Area.Area;

public interface TipoArea {
    Area moverse(TipoUnidad tipoUnidad, Area area);
}