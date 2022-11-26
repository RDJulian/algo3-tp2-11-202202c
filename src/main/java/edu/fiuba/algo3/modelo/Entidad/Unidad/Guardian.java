package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Guardian extends Unidad {
    public Guardian(Posicion posicion) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(4);
        this.accionAlPasarTurno = new Nada();
        this.vida = new Regenerativa(100);
        this.defensa = new SinEscudo();

        this.tipoUnidad = new UnidadAire();
        this.danioTierra = 25;
        this.danioAire = 0;
        this.rangoAtaque = 10;
    }
}
