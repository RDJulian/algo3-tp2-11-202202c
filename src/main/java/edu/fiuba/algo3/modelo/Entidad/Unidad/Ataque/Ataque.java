package edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;

public abstract class Ataque {
    protected Unidad unidadAtacante;
    protected Area areaAtacante;
    protected int danioTierra;
    protected int danioAire;
    protected int rangoAtaque;

    public abstract int calcularDanio(TipoUnidad tipoUnidad, Area areaObjetivo);

    public abstract void atacar(Entidad entidad, Area areaAtacante);

    public abstract int calcularDanio(Area area);
}
