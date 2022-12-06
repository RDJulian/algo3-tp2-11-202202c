package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Scout extends Unidad implements RevelaEntidades {
    private int radioDeDeteccion;

    public Scout(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoOperativo = new EnConstruccion(9);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new Consumidor(4);
        this.vida = new Normal(150);
        this.defensa = new Escudo(100);
        this.raza = raza;

        this.tipoUnidad = new UnidadAire();
        this.ataque = new Ataca(this, 8, 14, 4);
        this.contadorDeBajas = 0;

        this.radioDeDeteccion = 4;
    }

    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, radioDeDeteccion);
    }
}
