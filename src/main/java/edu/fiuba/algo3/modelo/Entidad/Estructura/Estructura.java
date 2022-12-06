package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class Estructura extends Entidad {
    @Override
    public void recibirAtaque(Ataque ataque, Unidad unidadAtacante) {
        estadoOperativo.atacable();
        estadoInvisibilidad.atacable();
        int danioARecibir = ataque.calcularDanio(posicion);
        daniar(danioARecibir, unidadAtacante);
    }

    public abstract void construible(ConstruibleEstructura requiereOtraEstructura);

    @Override
    public int afectarSuministro(int suministro) {
        return estadoOperativo.afectarSuministro(afectaSuministro, suministro);
    }
}