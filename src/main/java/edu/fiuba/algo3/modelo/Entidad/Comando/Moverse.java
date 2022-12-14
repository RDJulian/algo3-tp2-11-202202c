package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;

public class Moverse implements Comando {
    private final Unidad unidad;
    private final TipoUnidad tipoUnidad;
    private final Area area;

    public Moverse(Unidad unidad, TipoUnidad tipoUnidad, Area area) {
        this.unidad = unidad;
        this.tipoUnidad = tipoUnidad;
        this.area = area;
    }

    @Override
    public void ejecutar() {
        area.moverse(unidad, tipoUnidad);
    }
}
