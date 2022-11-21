package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Devorador extends Unidad {
    public Devorador(Posicion posicion) {
        super(posicion);
        this.radioAtaque = 5;
        this.rangoAtaque = new Rango(this.posicion, this.radioAtaque);
        this.danioAire = 15;
        this.danioTierra = 0;
        this.tipoUnidad = new UnidadAire();
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();
        this.estadoEntidad = new EnConstruccion(4);
    }
}
