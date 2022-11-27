package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Dragon extends Unidad {
    public Dragon(Posicion posicion) {
        super(posicion);
        this.radioAtaque = 4;
        this.rangoAtaque = new Rango(this.posicion, this.radioAtaque);
        this.danioAire = 20;
        this.danioTierra = 20;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Normal(100);
        this.defensa = new Escudo(80);
        this.estadoEntidad = new EnConstruccion(6);
        this.invisible = false;
    }
}
