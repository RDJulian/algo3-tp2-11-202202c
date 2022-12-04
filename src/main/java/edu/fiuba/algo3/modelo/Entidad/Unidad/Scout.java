package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Scout extends UnidadAtacante {
    public Scout(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoOperativo = new EnConstruccion(9);
        this.estadoInvisibilidad = new Visible();
        this.rolEnSuministro = new Consumidor(4);
        this.vida = new Normal(150);
        this.defensa = new Escudo(100);
        this.raza = raza;

        this.tipoUnidad = new UnidadAire();
        this.danioTierra = 8;
        this.danioAire = 14;
        this.rangoAtaque = 4;
        this.invisible = false;
        this.contadorDeBajas = 0;
    }
}
