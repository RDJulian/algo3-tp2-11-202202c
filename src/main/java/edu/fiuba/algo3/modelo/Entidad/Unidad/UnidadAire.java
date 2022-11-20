package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;

public class UnidadAire implements TipoUnidad {
    @Override
    public int recibirDanio(int danioAire, int danioTierra) {
        if (danioAire == 0) {
            throw new AtaqueNoValidoException();
        }
        return danioAire;
    }
}
