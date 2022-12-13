package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class Zerling extends Unidad {
    public Zerling(Area area, ArrayList<Estructura> estructuras, Zerg zerg) {
        this();
        raza = zerg;

        //Chequeos
        if (zerg.suministroRestante() < 1) {
            throw new SuministroInsuficienteException();
        }

        if (!(area.construible(new NoSobreRecurso(), new RangoMoho()) && new RequiereReservaDeReproduccion().construible(estructuras))) {
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

    public Zerling() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(35, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(2);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new Consumidor(1);

        this.tipoUnidad = new UnidadTierra();
        this.ataque = new Ataca(this, 4, 0, 1);
        this.contadorDeBajas = 0;
    }
}
