package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Area.TipoArea.AreaEspacial;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Area.Area;

public class UnidadAire extends TipoUnidad {
    @Override
    public Area movible(AreaEspacial area, Area posicion) {
        return posicion;
    }

    @Override
    public int recibirDanio(int danioAire, int danioTierra) {
        if (danioAire == 0) {
            throw new AtaqueNoValidoException();
        }
        return danioAire;
    }
}
