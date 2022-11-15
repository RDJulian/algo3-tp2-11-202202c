package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValido;

public class UnidadAire implements TipoUnidad {
    @Override
    public int recibirDanio(int danioAire, int danioTierra) {
        if (danioAire == 0) {
            throw new AtaqueNoValido();
        }
        return danioAire;
    }
}
