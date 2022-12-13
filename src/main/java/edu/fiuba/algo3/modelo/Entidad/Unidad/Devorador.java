package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoInvisibilidad.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Excepciones.SuministroInsuficienteException;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class Devorador extends Unidad implements UsaMementoInvisibilidad {
    private Invisibilidad invisibilidad;

    public Devorador(Area area, Zerg zerg) {
        this();
        raza = zerg;

        //Chequeos
        if (zerg.suministroRestante() < 4) {
            throw new SuministroInsuficienteException();
        }

        if (!area.construible(new NoSobreRecurso(), new RangoMoho())) {
            throw new ConstruccionNoValidaException();
        }

        try {
            this.area = area.ocupar();
            zerg.gastarRecursos(150, 50);
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        }

        zerg.registrarEntidad(this);
    }

    public Devorador() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(200, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Consumidor(4);

        this.tipoUnidad = new UnidadAire();
        this.ataque = new Ataca(this, 0, 15, 5);
        this.contadorDeBajas = 0;

        //Instanciacion de clases especificas a esta entidad
        this.invisibilidad = new Invisibilidad(this);
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
