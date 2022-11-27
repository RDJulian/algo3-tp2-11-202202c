package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zerling extends Unidad {
    public Zerling(Posicion posicion) {
        super(posicion);
        this.radioAtaque = 1;
        this.rangoAtaque = new Rango(this.posicion, this.radioAtaque);
        this.danioAire = 0;
        this.danioTierra = 4;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Regenerativa(35);
        this.defensa = new SinEscudo();
        this.estadoEntidad = new EnConstruccion(2);
        this.invisible = false;
    }
}
