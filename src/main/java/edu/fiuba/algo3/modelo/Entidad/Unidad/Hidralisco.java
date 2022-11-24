package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Hidralisco extends Unidad {
    public Hidralisco(Posicion posicion) {
        this.posicion = posicion;
        this.rangoAtaque = 4;
        this.danioAire = 10;
        this.danioTierra = 10;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Regenerativa(80);
        this.defensa = new SinEscudo();
        this.estadoEntidad = new EnConstruccion(4);
        this.accionAlPasarTurno = new Nada();
    }
}
