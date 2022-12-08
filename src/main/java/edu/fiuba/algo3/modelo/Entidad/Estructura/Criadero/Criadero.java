package edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Comando.GenerarLarva;
import edu.fiuba.algo3.modelo.Entidad.Comando.UsarExtractor;
import edu.fiuba.algo3.modelo.Entidad.Comando.UsarLarva;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.RevelaEntidades;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.ArrayList;

public class Criadero extends Estructura implements GeneraLarva, UsaMementoInvisibilidad {
    private Invisibilidad invisibilidad;
    private Larvas larvas;

    public Criadero(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();
        this.vida = new Regenerativa(500);
        this.defensa = new SinEscudo();
        this.raza = raza;
        this.larvas = new Larvas();
        this.invisibilidad = new Invisibilidad(this);
    }

    public void usarLarva() {
        estadoOperativo.operable(new UsarLarva(larvas));
    }

    @Override
    public void generarLarva() {
        larvas.generarLarva();
    }

    public Piso generarMoho() {
        return new Moho(posicion);
    }

    @Override
    public void pasarTurno() {
        estadoOperativo.pasarTurno(vida, defensa, new GenerarLarva(this));
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