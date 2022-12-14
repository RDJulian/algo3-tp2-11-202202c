package edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

public abstract class Ataque {
    protected Unidad unidadAtacante;
    protected Area areaAtacante;
    protected int danioTierra;
    protected int danioAire;
    protected int rangoAtaque;

    protected Raza razaAtacante;
    protected boolean atacoEsteTurno;

    public abstract int calcularDanio(TipoUnidad tipoUnidad);

    public abstract int calcularDanio();

    public abstract void atacar(Entidad entidad, Area areaAtacante, Raza razaAtacante);

    //Band-aid para no tener que cambiar todos los tests.
    public boolean ataqueValido(Area areaObjetivo, Raza razaObjetivo) {
        return areaObjetivo.enRango(areaAtacante, rangoAtaque) && (razaObjetivo != razaAtacante || razaObjetivo == null || razaAtacante == null);
    }

    public void pasarTurno() {
        atacoEsteTurno = false;
    }
}
