package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class Estructura extends Entidad {
    @Override
    public void daniar(int danioTierra, int danioAire, Posicion posicionAtacante, int rangoAtaque, Unidad unidadAtacante) {
        estadoEntidad.atacable();
        if (danioTierra == 0 || !posicion.enRango(posicionAtacante, rangoAtaque)) {
            throw new AtaqueNoValidoException();
        }
        defensa.proteger(this, vida, danioTierra, unidadAtacante);
    }

    public abstract void construible(ConstruibleEstructura requiereOtraEstructura);
}