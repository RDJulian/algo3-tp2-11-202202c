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

    protected int radioDeDeteccion;
    protected Rango rangoDeDeteccion;

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
        this.invisible = true;
        this.radioDeDeteccion = 4;
        this.rangoDeDeteccion = new Rango(this.posicion, this.radioDeDeteccion);
    }

    @Override
    public void atacar(Daniable daniable) {
        throw new AtaqueNoValidoException();
    }

    public boolean fueraDeRango(Posicion posicion){
        return this.rangoDeDeteccion.noIncluye(posicion);
    }
}
