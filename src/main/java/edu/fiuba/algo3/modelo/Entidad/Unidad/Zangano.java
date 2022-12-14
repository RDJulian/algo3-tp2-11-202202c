package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereCriadero;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.Moverse;
import edu.fiuba.algo3.modelo.Entidad.Comando.UsarExtractor;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.NoAtaca;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class Zangano extends Unidad implements ExtraeRecurso {
    private Zerg zerg;

    public Zangano(Area area, ArrayList<Estructura> estructuras, Zerg zerg) {
        this();
        raza = zerg;
        this.zerg = zerg;

        //Chequeos
        if (zerg.suministroRestante() < 1) {
            throw new SuministroInsuficienteException();
        }

        if (!(area.construible(new NoSobreRecurso(), new RangoMoho()) && new RequiereCriadero().construible(estructuras))) {
            throw new ConstruccionNoValidaException();
        }

        try {
            this.area = area.ocupar();
            zerg.gastarRecursos(25, 0);
            zerg.usarLarva();
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        } catch (RazaZergSinLarvasException e) {
            area.desocupar();
            zerg.recolectarMineral(25);
            zerg.recolectarGas(0);
            throw new ConstruccionNoValidaException();
        }

        zerg.registrarEntidad(this);
    }

    public Zangano(Area area, Zerg zerg) {
        this();
        this.area = area;
        raza = zerg;
        this.zerg = zerg;
    }

    public Zangano() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(25, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(1);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new Consumidor(1);

        this.tipoUnidad = new UnidadTierra();
        this.ataque = new NoAtaca();
        this.contadorDeBajas = 0;
    }

    //Supuesto: un Zangano puede moverse sobre un mineral y ocuparlo, a diferencia de todas las demas unidades.
    //No puede moverse por un volcan de gas, pero si hay un extractor, se setea su area sin ocuparla. Si esta saliendo
    //de un extractor, no desocupa el area y se retira de el. Si no se cumple lo anterior, desocupa el area.
    @Override
    public void moverse(Area area) {
        if (area.es(this.area) || !area.enRango(this.area, 3) || seMovioEsteTurno) {
            throw new MovimientoNoValidoException();
        }

        Area areaAnterior = this.area;
        Extractor extractor = zerg.buscarExtractor(area);

        try {
            estadoOperativo.operable(new Moverse(this, tipoUnidad, area));
            this.area = area;
        } catch (MovimientoSobreRecursoException e) {
            if (extractor != null) {
                extractor.agregarZangano(this);
                this.area = area;
            } else {
                throw e;
            }
        }

        extractor = zerg.buscarExtractor(areaAnterior);
        if (extractor != null) {
            extractor.quitarZangano(this);
        } else {
            areaAnterior.desocupar();
        }
        seMovioEsteTurno = true;
    }

    public void usarExtractor(Area area) {
        estadoOperativo.operable(new UsarExtractor(area, raza));
    }

    @Override
    public void extraerRecurso() {
        if (area != null) {
            area.extraerRecurso(10, raza);
        }
    }

    @Override
    public void pasarTurno() {
        estadoOperativo = estadoOperativo.pasarTurno(vida, escudo, new ExtraerRecurso(this));
        this.ataque.pasarTurno();
        seMovioEsteTurno = false;
    }

    @Override
    public boolean movible(Recurso recurso) {
        return recurso.visitar(this);
    }
}