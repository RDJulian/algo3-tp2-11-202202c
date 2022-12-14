package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.RevelarEntidad;
import edu.fiuba.algo3.modelo.Entidad.EntidadInvisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EstadoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.NoAtaca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class AmoSupremo extends Unidad implements RevelaEntidades, UsaMementoInvisibilidad, EntidadInvisible {
    private Invisibilidad invisibilidad;
    private int radioDeDeteccion;

    public AmoSupremo(Area area, Zerg zerg) {
        this();
        raza = zerg;

        //Chequeos
        if (!area.construible(new NoSobreRecurso(), new RangoMoho())) {
            throw new ConstruccionNoValidaException();
        }

        //Ver como mejorar.
        try {
            this.area = area.ocupar();
            zerg.gastarRecursos(50, 0);
            zerg.usarLarva();
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        } catch (RazaZergSinLarvasException e) {
            area.desocupar();
            zerg.recolectarMineral(50);
            zerg.recolectarGas(0);
            throw new ConstruccionNoValidaException();
        }

        zerg.registrarEntidad(this);
    }

    public AmoSupremo(Area area) {
        this();
        this.area = area;
    }

    public AmoSupremo() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(200, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(5);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();

        this.tipoUnidad = new UnidadAire();
        this.ataque = new NoAtaca();
        this.contadorDeBajas = 0;

        //Instanciacion de clases especificas a esta entidad
        this.invisibilidad = new Invisibilidad(this);
        this.radioDeDeteccion = 4;
    }

    @Override
    public void pasarTurno() {
        EstadoOperativo estadoAnterior = estadoOperativo;
        super.pasarTurno();
        if (estadoAnterior != estadoOperativo && raza != null) {
            raza.revelarContrincante();
        }
    }

    @Override
    public void moverse(Area area) {
        super.moverse(area);

        if (raza != null) {
            raza.revelarUnidad(this);
            raza.revelarContrincante();
        }
    }

    @Override
    public int afectarSuministro(int suministro) {
        return estadoOperativo.afectarSuministro(afectaSuministro, suministro);
    }

    @Override
    public boolean revelar(Area area) {
        return estadoOperativo.operable(new RevelarEntidad(area, this.area, radioDeDeteccion));
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
}