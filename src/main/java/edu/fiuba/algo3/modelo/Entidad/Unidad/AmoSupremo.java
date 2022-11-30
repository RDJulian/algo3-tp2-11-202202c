package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
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
        this.estadoEntidad = new EnConstruccion(new Proveedor(), 5);
        this.accionAlPasarTurno = new Nada();
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();
        this.raza = raza;

        this.tipoUnidad = new UnidadAire();
        this.danioTierra = 0;
        this.danioAire = 0;
        this.rangoAtaque = 0;
        this.invisible = true;
        this.contadorDeBajas = 0;

        this.radioDeDeteccion = 4;
    }

    @Override
    public int afectarSuministro(int suministro) {
        return estadoEntidad.afectarSuministro(suministro);
    }

    @Override
    public void atacar(Entidad entidad) {
        throw new AtaqueNoValidoException();
    }

    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, radioDeDeteccion);
    }
}
