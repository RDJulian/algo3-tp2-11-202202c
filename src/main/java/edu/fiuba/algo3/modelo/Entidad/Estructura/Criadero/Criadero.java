package edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.GenerarLarva;
import edu.fiuba.algo3.modelo.Entidad.Comando.UsarLarva;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EstadoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.RevelaEntidades;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;

import java.util.ArrayList;

public class Criadero extends Estructura implements GeneraLarva, UsaMementoInvisibilidad {
    private Larvas larvas;
    private Invisibilidad invisibilidad;

    public Criadero(Area area, Raza raza) {
        //Chequeos
        try {
            this.area = area.ocupar();
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        }

        try {
            raza.gastarRecursos(200, 0);
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        }

        boolean construible = new NoSobreRecurso().construible(area)
                && new RangoMoho().construible(area);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        //Instanciacion de clases comunes
        this.raza = raza;
        this.vida = new Regenerativa(500, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();

        //Instanciacion de clases especificas a esta entidad
        this.larvas = new Larvas();
        this.invisibilidad = new Invisibilidad(this);

        raza.registarEntidad(this);
    }

    @Override
    public void usarLarva() {
        estadoOperativo.operable(new UsarLarva(larvas));
    }

    @Override
    public void generarLarva() {
        larvas.generarLarva();
    }

    private void generarMoho() {
        Mapa.obtenerInstancia().agregarPiso(new Moho(area));
    }

    //Tener cuidado con este metodo. Si cambia de "En construccion" a "Destruido" se generaria moho.
    //Solo se va a llamar a pasarTurno() desde la raza, y si se destruye no estaria en la lista.
    @Override
    public void pasarTurno() {
        EstadoOperativo estadoAnterior = estadoOperativo;
        estadoOperativo = estadoOperativo.pasarTurno(vida, escudo, new GenerarLarva(this));
        if (estadoAnterior != estadoAnterior) {
            generarMoho();
        }
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
        invisibilidad.actualizarEstado(reveladores, area);
    }

    @Override
    public boolean permitirCorrelatividad(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}