package edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.GenerarLarva;
import edu.fiuba.algo3.modelo.Entidad.Comando.UsarLarva;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.RevelaEntidades;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Entidad.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Vida.SinEscudo;

import java.util.ArrayList;

public class Criadero extends Estructura implements GeneraLarva, UsaMementoInvisibilidad {
    private Larvas larvas;
    private Invisibilidad invisibilidad;

    public Criadero(Area area, Raza raza) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(200, 0);


        boolean construible = new NoSobreRecurso().construible(area)
                && new RangoMoho().construible(area);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        this.area = area.ocupar();
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(500);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();

        //Instanciacion de clases especificas a esta entidad
        this.larvas = new Larvas();
        this.invisibilidad = new Invisibilidad(this);


        raza.registarEntidad(this);
    }

    //Constructor para testear.
    public Criadero() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(500);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();

        //Instanciacion de clases especificas a esta entidad
        this.larvas = new Larvas();
        this.invisibilidad = new Invisibilidad(this);
        this.raza = new Raza();
    }

    public void usarLarva() {
        estadoOperativo.operable(new UsarLarva(larvas));
    }

    @Override
    public void generarLarva() {
        larvas.generarLarva();
    }

    public Piso generarMoho() {
        return new Moho(area);
    }

    @Override
    public void pasarTurno() {
        estadoOperativo = estadoOperativo.pasarTurno(vida, defensa, new GenerarLarva(this));
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
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}