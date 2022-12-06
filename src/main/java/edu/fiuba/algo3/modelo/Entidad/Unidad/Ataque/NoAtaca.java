package edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class NoAtaca extends Ataque {
    @Override
    public int calcularDanio(TipoUnidad tipoUnidad, Posicion posicionObjetivo) {
        return 0;
    }

    @Override
    public void atacar(Entidad entidad, Posicion posicionAtacante) {
        throw new AtaqueNoValidoException();
    }

    @Override
    public int calcularDanio(Posicion posicion) {
        return 0;
    }
}
