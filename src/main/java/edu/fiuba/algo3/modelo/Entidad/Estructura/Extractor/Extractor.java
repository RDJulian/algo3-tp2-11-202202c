package edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.SobreGasVespeno;
import edu.fiuba.algo3.modelo.Entidad.Comando.AgregarZangano;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.EstructuraNoRequerida;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;
import edu.fiuba.algo3.modelo.Raza.Zerg;

public class Extractor extends Estructura implements ExtraeRecurso, AgregaZanganos, EstructuraNoRequerida {
    private Zanganos zanganos;

    public Extractor(Area area, Zerg zerg) {
        this();
        raza = zerg;

        //Chequeos
        if (!area.construible(new SobreGasVespeno(), new RangoMoho())) {
            throw new ConstruccionNoValidaException();
        }

        try {
            this.area = area.ocupar();
            zerg.gastarRecursos(100, 0);
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        }

        zerg.registrarEntidad(this);
    }

    public Extractor(Area area) {
        this();
        this.area = area;
    }

    public Extractor() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(750, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(6);
        this.estadoInvisibilidadEntidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.zanganos = new Zanganos();
    }

    @Override
    public void agregarZangano(Zangano zangano) {
        estadoOperativo.operable(new AgregarZangano(zanganos, zangano));
    }

    @Override
    public void quitarZangano(Zangano zangano) {
        zanganos.quitarZangano(zangano);
    }

    @Override
    public void extraerRecurso() {
        if (area != null) {
            zanganos.extraerRecurso(area);
        }
    }

    @Override
    public void pasarTurno() {
        estadoOperativo = estadoOperativo.pasarTurno(vida, escudo, new ExtraerRecurso(this));
    }

    @Override
    public boolean permitirCorrelatividad(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }

    public Extractor estaConstruidaEnArea(Area area) {
        if (area == this.area) {
            return this;
        }
        return null;
    }
}