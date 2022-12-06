package edu.fiuba.algo3.modelo.Posicion.Area;

import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class AreaEspacial extends Area {
    @Override
    public void movible(TipoUnidad tipoUnidad) {
        tipoUnidad.movible(this);
    }
}
