package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.NoAtaca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.ArrayList;

public class AmoSupremo extends Unidad implements RevelaEntidades, UsaMementoInvisibilidad {
    private Invisibilidad invisibilidad;
    private int radioDeDeteccion;

    public AmoSupremo(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoOperativo = new EnConstruccion(5);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();
        this.raza = raza;

        this.tipoUnidad = new UnidadAire();
        this.ataque = new NoAtaca();
        this.invisibilidad = new Invisibilidad(this);

        this.radioDeDeteccion = 4;
    }

    @Override
    public int afectarSuministro(int suministro) {
        return estadoOperativo.afectarSuministro(afectaSuministro, suministro);
    }

    @Override
    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, radioDeDeteccion);
    }

    @Override
    public MementoInvisibilidad guardarEstado() {
        MementoInvisibilidad snapshot = new MementoInvisibilidad(estadoInvisibilidad);
        this.estadoInvisibilidad = new Visible();
        return snapshot;
    }

    @Override
    public void restaurarEstado(MementoInvisibilidad snapshot) {
        this.estadoInvisibilidad = snapshot.restaurar();
    }

    @Override
    public void actualizarEstado(ArrayList<RevelaEntidades> reveladores) {
        invisibilidad.actualizarEstado(reveladores, posicion);
    }
}