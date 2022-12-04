package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Devorador extends UnidadAtacante {
    public Devorador(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Invisible();
        this.rolEnSuministro = new Consumidor(4);
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();
        this.raza = raza;

        this.tipoUnidad = new UnidadAire();
        this.danioTierra = 0;
        this.danioAire = 15;
        this.rangoAtaque = 5;
        this.invisible = true;
        this.contadorDeBajas = 0;
    }
}
