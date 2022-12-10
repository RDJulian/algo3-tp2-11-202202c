package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Area.TipoArea.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.Area;

public abstract class TipoUnidad {
    public Area movible(Area area) {
        return area.ocupar();
    }

    public abstract Area movible(AreaEspacial area, Area posicion);

    public abstract int recibirDanio(int danioAire, int danioTierra);
}
