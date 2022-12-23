package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Area.TipoArea.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;

public abstract class TipoUnidad {
    public abstract Area moverse(AreaTierra area, Area posicion);

    public abstract Area moverse(AreaEspacial area, Area posicion);
    
    public abstract int recibirDanio(int danioAire, int danioTierra);
}
