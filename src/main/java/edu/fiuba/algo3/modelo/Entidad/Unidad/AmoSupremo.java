package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Proveedor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class AmoSupremo extends Unidad {

    protected int radioDeDeteccion;

    public AmoSupremo(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(5);
        this.rolEnSuministro = new Proveedor();
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();
        this.raza = raza;

        this.tipoUnidad = new UnidadAire();
        this.invisible = true;

        this.radioDeDeteccion = 4;
    }

    @Override
    public int afectarSuministro(int suministro) {
        return estadoEntidad.afectarSuministro(rolEnSuministro, suministro);
    }

    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, radioDeDeteccion);
    }
}
