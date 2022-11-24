package edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Area.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;

public class UnidadAire implements TipoUnidad {
    //Una unidad de aire puede moverse libremente.
    @Override
    public void visitar(AreaTierra area){}
    @Override
    public void visitar(AreaEspacial area){}

    @Override
    public int recibirDanio(int danioAire, int danioTierra) {
        if (danioAire == 0) {
            throw new AtaqueNoValidoException();
        }
        return danioAire;
    }
}
