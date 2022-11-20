package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Scout extends Unidad {
    public Scout() {
        this.danioAire = 14;
        this.danioTierra = 8;
        this.tipoUnidad = new UnidadAire();
        this.vida = new Normal(150);
        this.defensa = new Escudo(100);
        this.estadoEstructura = new EnConstruccion(9);
    }
}
