package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Hidralisco extends UnidadAtacante {
    public Hidralisco(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Visible();
        this.rolEnSuministro = new Consumidor(2);
        this.vida = new Regenerativa(80);
        this.defensa = new SinEscudo();
        this.raza = raza;

        this.tipoUnidad = new UnidadTierra();
        this.danioTierra = 10;
        this.danioAire = 10;
        this.rangoAtaque = 4;
        this.invisible = false;
        this.contadorDeBajas = 0;
    }
}
