package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.Daniable;
import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class AmoSupremo extends Unidad {
    public AmoSupremo(Posicion posicion) {
        super(posicion);
        this.radioAtaque = 0;
        this.rangoAtaque = new Rango(this.posicion, this.radioAtaque);
        this.danioAire = 0;
        this.danioTierra = 0;
        this.tipoUnidad = new UnidadAire();
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();
        this.estadoEntidad = new EnConstruccion(5);
    }

    @Override
    public void atacar(Daniable daniable) {
        throw new AtaqueNoValidoException();
    }
}