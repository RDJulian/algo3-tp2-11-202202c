package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Guardian extends Unidad {
    public Guardian(Posicion posicion) {
        super(posicion);
        this.radioAtaque = 10;
        this.rangoAtaque = new Rango(this.posicion, this.radioAtaque);
        this.danioAire = 0;
        this.danioTierra = 25;
        this.tipoUnidad = new UnidadAire();
        this.vida = new Regenerativa(100);
        this.defensa = new SinEscudo();
        this.estadoEntidad = new EnConstruccion(4);
        this.invisible = false;
    }
}
