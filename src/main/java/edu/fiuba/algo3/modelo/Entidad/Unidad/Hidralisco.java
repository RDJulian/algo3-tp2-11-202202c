package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereGuarida;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class Hidralisco extends Unidad {
    public Hidralisco(Area area, ArrayList<Estructura> estructuras, Zerg zerg) {
        this();
        raza = zerg;

        //Chequeos
        if (zerg.suministroRestante() < 2) {
            throw new SuministroInsuficienteException();
        }

        if (!(area.construible(new NoSobreRecurso(), new RangoMoho()) && new RequiereGuarida().construible(estructuras))) {
            throw new ConstruccionNoValidaException();
        }

        try {
            this.area = area.ocupar();
            zerg.gastarRecursos(75, 25);
            zerg.usarLarva();
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        } catch (RazaZergSinLarvasException e) {
            area.desocupar();
            zerg.recolectarMineral(75);
            zerg.recolectarGas(25);
            throw new ConstruccionNoValidaException();
        }

        zerg.registrarEntidad(this);
    }

    public Hidralisco(Area area) {
        this();
        this.area = area;
    }

    public Hidralisco() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(80, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidadEntidad = new Visible();
        this.afectaSuministro = new Consumidor(2);

        this.tipoUnidad = new UnidadTierra();
        this.ataque = new Ataca(this, 10, 10, 4);
        this.contadorDeBajas = 0;
    }
}
