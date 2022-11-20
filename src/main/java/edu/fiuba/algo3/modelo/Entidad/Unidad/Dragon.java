package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Dragon extends Unidad {
    public Dragon() {
        this.danioAire = 20;
        this.danioTierra = 20;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Normal(100);
        this.defensa = new Escudo(80);
        this.estadoEntidad = new EnConstruccion(6);
    }
}
