package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zerling extends Unidad {
    public Zerling(Posicion posicion) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(2);
        this.accionAlPasarTurno = new Nada();
        this.rolEnSuministro = new Consumidor(1);
        this.vida = new Regenerativa(35);
        this.defensa = new SinEscudo();

        this.tipoUnidad = new UnidadTierra();
        this.danioTierra = 4;
        this.danioAire = 0;
        this.rangoAtaque = 1;
    }
}
