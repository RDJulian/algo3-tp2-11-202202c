package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Zealot extends Unidad {
    public Zealot(Posicion posicion) {
        super(posicion);
        this.radioAtaque = 1;
        this.rangoAtaque = new Rango(this.posicion, this.radioAtaque);
        this.danioAire = 0;
        this.danioTierra = 8;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Normal(100);
        this.defensa = new Escudo(60);
        this.estadoEntidad = new EnConstruccion(4);
        this.invisible = false;
    }
}
