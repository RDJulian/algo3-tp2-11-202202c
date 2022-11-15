package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValido;

public class UnidadTierra implements TipoUnidad {
    //Esta excepcion no se prueba.
    @Override
    public int recibirDanio(int danioAire, int danioTierra) {
        if (danioTierra == 0) {
            throw new AtaqueNoValido();
        }
        return danioTierra;
    }
}