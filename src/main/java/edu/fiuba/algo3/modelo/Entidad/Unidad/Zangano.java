package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereCriadero;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.UsarExtractor;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.NoAtaca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;

import java.util.ArrayList;

public class Zangano extends Unidad implements ExtraeRecurso {

    public Zangano(Area area, Raza raza, ArrayList<Estructura> estructuras) {
        //Chequeos
        raza.usarLarva();
        if (raza.suministroRestante() < 1) {
            throw new SuministroInsuficienteException();
        }

        try {
            this.area = area.ocupar();
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        }

        try {
            raza.gastarRecursos(25, 0);
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        }

        boolean construible = new NoSobreRecurso().construible(area)
                && new RangoMoho().construible(area)
                && new RequiereCriadero().construible(estructuras);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        //Instanciacion de clases comunes
        this.raza = raza;
        this.vida = new Regenerativa(25, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(1);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new Consumidor(1);

        this.tipoUnidad = new UnidadTierra();
        this.ataque = new NoAtaca();
        this.contadorDeBajas = 0;

        raza.registarEntidad(this);
    }

    //Supuesto: un Zangano puede moverse sobre un mineral y ocuparlo, a diferencia de todas las demas unidades.
    //No puede moverse por un volcan de gas, pero si hay un extractor, se setea su area sin ocuparla. Si esta saliendo
    //de un extractor, no desocupa el area y se retira de el. Si no se cumple lo anterior, desocupa el area.
    @Override
    public void moverse(Area area) {
        Area areaAnterior = this.area;
        Extractor extractor = raza.buscarExtractor(area);

        try {
            this.area = area.moverse(this, tipoUnidad);
        } catch (MovimientoSobreRecursoException e) {
            if (extractor != null) {
                extractor.agregarZangano(this);
                this.area = area;
            } else {
                throw e;
            }
        }

        extractor = raza.buscarExtractor(areaAnterior);
        if (extractor != null) {
            extractor.quitarZangano(this);
        } else {
            areaAnterior.desocupar();
        }
    }

    public void usarExtractor(Area area) {
        estadoOperativo.operable(new UsarExtractor(area, raza));
    }

    @Override
    public void extraerRecurso() {
        area.extraerRecurso(10, raza);
    }

    @Override
    public void pasarTurno() {
        estadoOperativo = estadoOperativo.pasarTurno(vida, escudo, new ExtraerRecurso(this));
    }
}