package edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class NoAtaca extends Ataque {
    @Override
    public int calcularDanio(TipoUnidad tipoUnidad) {
        return 0;
    }

    @Override
    public int calcularDanio() {
        return 0;
    }

    @Override
    public void atacar(Entidad entidad, Area areaAtacante, Raza razaAtacante) {
        throw new AtaqueNoValidoException();
    }
}
