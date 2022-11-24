package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Area.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;

public class UnidadTierra implements TipoUnidad {
    @Override
    public void visitar(AreaTierra area){}
    @Override
    public void visitar(AreaEspacial area){
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