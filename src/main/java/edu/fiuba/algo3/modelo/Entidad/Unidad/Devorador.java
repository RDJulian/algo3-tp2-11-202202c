package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Devorador extends Unidad {
    public Devorador(Posicion posicion) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(4);
        this.accionAlPasarTurno = new Nada();
        this.rolEnSuministro = new Consumidor(4);
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();

        this.tipoUnidad = new UnidadAire();
        this.danioTierra = 0;
        this.danioAire = 15;
        this.rangoAtaque = 5;
        this.invisible = true;
    }
}
