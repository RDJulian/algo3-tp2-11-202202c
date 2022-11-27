package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Scout extends Unidad {
    public Scout(Posicion posicion) {
        super(posicion);
        this.radioAtaque = 4;
        this.rangoAtaque = new Rango(this.posicion, this.radioAtaque);
        this.danioAire = 14;
        this.danioTierra = 8;
        this.tipoUnidad = new UnidadAire();
        this.vida = new Normal(150);
        this.defensa = new Escudo(100);
        this.estadoEntidad = new EnConstruccion(9);
        this.invisible = false;
    }
}
