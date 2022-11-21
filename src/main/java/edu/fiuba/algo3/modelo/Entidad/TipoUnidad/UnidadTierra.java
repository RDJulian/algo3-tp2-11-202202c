package edu.fiuba.algo3.modelo.Entidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;

public class UnidadTierra implements TipoUnidad {
    @Override
    public void manejar(Class<?> clase) {
        if (clase != AreaTierra.class) {
            throw new MovimientoNoValidoException();
        }
    }

    //Esta excepcion no se prueba.
    @Override
    public int recibirDanio(int danioAire, int danioTierra) {
        if (danioTierra == 0) {
            throw new AtaqueNoValidoException();
        }
        return danioTierra;
    }
}