package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Dragon extends Unidad {
    public Dragon(Posicion posicion) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(6);
        this.accionAlPasarTurno = new Nada();
        this.rolEnSuministro = new Consumidor(3);
        this.vida = new Normal(100);
        this.defensa = new Escudo(80);

        this.tipoUnidad = new UnidadTierra();
        this.danioTierra = 20;
        this.danioAire = 20;
        this.rangoAtaque = 4;
        this.invisible = false;
    }
}
