package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Zealot extends Unidad {
    public Zealot(Posicion posicion) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(4);
        this.accionAlPasarTurno = new Nada();
        this.vida = new Normal(100);
        this.defensa = new Escudo(60);

        this.tipoUnidad = new UnidadTierra();
        this.danioTierra = 8;
        this.danioAire = 0;
        this.rangoAtaque = 1;
    }
}
