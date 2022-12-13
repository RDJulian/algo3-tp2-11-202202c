package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Area.TipoArea.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;
import edu.fiuba.algo3.modelo.Area.Area;

public class UnidadTierra extends TipoUnidad {
    @Override
    public Area moverse(AreaTierra area, Area posicion) {
        return posicion.ocupar();
    }

    @Override
    public Area moverse(AreaEspacial area, Area posicion) {
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