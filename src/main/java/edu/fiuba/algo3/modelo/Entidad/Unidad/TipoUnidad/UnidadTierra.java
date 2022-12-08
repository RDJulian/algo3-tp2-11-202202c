package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Posicion.Area.AreaEspacial;
import edu.fiuba.algo3.modelo.Posicion.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class UnidadTierra extends TipoUnidad {
    @Override
    public Posicion movible(AreaEspacial area, Posicion posicion) {
        throw new MovimientoNoValidoException();
    }

    @Override
    public int recibirDanio(int danioAire, int danioTierra) {
        if (danioTierra == 0) {
            throw new AtaqueNoValidoException();
        }
        return danioTierra;
    }
}