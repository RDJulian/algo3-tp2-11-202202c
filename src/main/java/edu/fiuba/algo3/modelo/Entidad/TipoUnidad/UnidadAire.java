package edu.fiuba.algo3.modelo.Entidad.TipoUnidad;

import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;

public class UnidadAire implements TipoUnidad {
    //Una unidad de aire puede moverse libremente.
    @Override
    public void manejar(Class<?> clase) {

    }

    @Override
    public int recibirDanio(int danioAire, int danioTierra) {
        if (danioAire == 0) {
            throw new AtaqueNoValidoException();
        }
        return danioAire;
    }
}
