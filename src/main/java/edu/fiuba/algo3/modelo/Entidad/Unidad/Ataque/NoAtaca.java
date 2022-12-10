package edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Area.Area;

public class NoAtaca extends Ataque {
    @Override
    public int calcularDanio(TipoUnidad tipoUnidad, Area areaObjetivo) {
        return 0;
    }

    @Override
    public void atacar(Entidad entidad, Area areaAtacante) {
        throw new AtaqueNoValidoException();
    }

    @Override
    public int calcularDanio(Area area) {
        return 0;
    }
}
