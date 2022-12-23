package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereAcceso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.ConEscudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Normal;
import edu.fiuba.algo3.modelo.Entidad.EntidadInvisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;

import java.util.ArrayList;

public class Zealot extends Unidad implements UsaMementoInvisibilidad, EntidadInvisible {
    private Invisibilidad invisibilidad;

    public Zealot(Area area, ArrayList<Estructura> estructuras, Protoss protoss) {
        this();
        raza = protoss;

        //Chequeos
        if (protoss.suministroRestante() < 2) {
            throw new SuministroInsuficienteException();
        }

        if (!(area.construible(new NoSobreRecurso(), new RangoPilon()) && new RequiereAcceso().construible(estructuras))) {
            throw new ConstruccionNoValidaException();
        }

        try {
            this.area = area.ocupar();
            protoss.gastarRecursos(100, 0);
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        }

        protoss.registrarEntidad(this);
    }

    public Zealot(Area area) {
        this();
        this.area = area;
    }

    public Zealot() {
        //Instanciacion de clases comunes
        this.vida = new Normal(100, this);
        this.escudo = new ConEscudo(60, vida);

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidadEntidad = new Visible();
        this.afectaSuministro = new Consumidor(2);

        this.tipoUnidad = new UnidadTierra();
        this.ataque = new Ataca(this, 8, 0, 1);
        this.contadorDeBajas = 0;

        //Instanciacion de clases especificas a esta entidad
        this.invisibilidad = new Invisibilidad(this);
    }

    @Override
    public void moverse(Area area) {
        super.moverse(area);

        if (raza != null) {
            raza.revelarUnidad(this);
        }
    }

    @Override
    public void sumarBaja() {
        contadorDeBajas = contadorDeBajas + 1;
        if (contadorDeBajas == 3) {
            estadoInvisibilidadEntidad = new Invisible();
            invisibilidad.sincronizarEstado();
        }
    }

    @Override
    public MementoInvisibilidad guardarEstado() {
        MementoInvisibilidad snapshot = new MementoInvisibilidad(estadoInvisibilidadEntidad);
        this.estadoInvisibilidadEntidad = new Visible();
        return snapshot;
    }

    @Override
    public void restaurarEstado(MementoInvisibilidad snapshot) {
        this.estadoInvisibilidadEntidad = snapshot.restaurar();
    }

    @Override
    public void actualizarEstado(ArrayList<RevelaEntidades> reveladores) {
        invisibilidad.actualizarEstado(reveladores, area);
    }
}