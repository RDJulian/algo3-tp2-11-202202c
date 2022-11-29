package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Area.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.AreaTierra;

public interface TipoUnidad {
    void visitar(AreaTierra area);

    void visitar(AreaEspacial area);

    int recibirDanio(int danioAire, int danioTierra);
}
