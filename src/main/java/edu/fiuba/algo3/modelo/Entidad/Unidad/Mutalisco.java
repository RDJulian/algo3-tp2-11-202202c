package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereEspiral;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.EvolucionarADevorador;
import edu.fiuba.algo3.modelo.Entidad.Comando.EvolucionarAGuardian;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Suministro.AfectaSuministro;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class Mutalisco extends Unidad {
    private Zerg zerg;

    public Mutalisco(Area area, ArrayList<Estructura> estructuras, Zerg zerg) {
        this();
        raza = zerg;
        this.zerg = zerg;

        //Chequeos
        if (zerg.suministroRestante() < 4) {
            throw new SuministroInsuficienteException();
        }

        if (!(area.construible(new NoSobreRecurso(), new RangoMoho()) && new RequiereEspiral().construible(estructuras))) {
            throw new ConstruccionNoValidaException();
        }

        try {
            this.area = area.ocupar();
            zerg.gastarRecursos(100, 100);
            zerg.usarLarva();
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        } catch (RazaZergSinLarvasException e) {
            area.desocupar();
            zerg.recolectarMineral(100);
            zerg.recolectarGas(100);
            throw new ConstruccionNoValidaException();
        }

        zerg.registrarEntidad(this);
    }

    public Mutalisco(Area area) {
        this();
        this.area = area;
    }

    public Mutalisco() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(120, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(7);
        this.estadoInvisibilidadEntidad = new Visible();
        this.afectaSuministro = new Consumidor(4);

        this.tipoUnidad = new UnidadAire();
        this.ataque = new Ataca(this, 9, 9, 3);
        this.contadorDeBajas = 0;
    }

    public void evolucionarAGuardian() {
        AfectaSuministro anterior = this.afectaSuministro;
        this.afectaSuministro = new NoAfecta();
        area.desocupar();

        try {
            estadoOperativo.operable(new EvolucionarAGuardian(zerg, area));
        } catch (ConstruccionNoValidaException e) {
            this.afectaSuministro = anterior;
            area.ocupar();
            throw new EvolucionNoValidaException();
        }

        destruir();
    }

    public void evolucionarADevorador() {
        AfectaSuministro anterior = this.afectaSuministro;
        this.afectaSuministro = new NoAfecta();
        area.desocupar();

        try {
            estadoOperativo.operable(new EvolucionarADevorador(zerg, area));
        } catch (ConstruccionNoValidaException e) {
            this.afectaSuministro = anterior;
            area.ocupar();
            throw new EvolucionNoValidaException();
        }

        destruir();
    }
}
