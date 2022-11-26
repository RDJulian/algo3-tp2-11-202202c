package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Scout extends Unidad {
    public Scout(Posicion posicion) {
        this.posicion = posicion;
        this.rangoAtaque = 4;
        this.danioAire = 14;
        this.danioTierra = 8;
        this.tipoUnidad = new UnidadAire();
        this.vida = new Normal(150);
        this.defensa = new Escudo(100);
        this.estadoEntidad = new EnConstruccion(9);
        this.accionAlPasarTurno = new Nada();

        this.rolEnSuministro = new Consumidor(4);
    }
}
