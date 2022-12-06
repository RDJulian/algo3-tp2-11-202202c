package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Posicion.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class Unidad extends Entidad {
    protected int contadorDeBajas;
    protected TipoUnidad tipoUnidad;
    protected Ataque ataque;

    public void atacar(Entidad entidad) {
        estadoOperativo.operable();
        ataque.atacar(entidad, posicion);
    }

    @Override
    public void recibirAtaque(Ataque ataque, Unidad unidadAtacante) {
        estadoOperativo.atacable();
        estadoInvisibilidad.atacable();
        int danioARecibir = ataque.calcularDanio(tipoUnidad, posicion);
        daniar(danioARecibir, unidadAtacante);
    }

    public void moverse(Posicion posicion) {
        posicion.movible(tipoUnidad);
        this.posicion = posicion;
    }

    @Override
    public int afectarSuministro(int suministro) {
        return afectaSuministro.afectarSuministro(suministro);
    }

    public void sumarBaja() {
        contadorDeBajas += 1;
    }
}
