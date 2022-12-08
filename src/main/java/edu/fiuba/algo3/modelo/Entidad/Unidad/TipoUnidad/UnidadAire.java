package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Posicion.Area.AreaEspacial;
import edu.fiuba.algo3.modelo.Posicion.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class UnidadAire extends TipoUnidad {
    @Override
    public Posicion movible(AreaEspacial area, Posicion posicion) {
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
