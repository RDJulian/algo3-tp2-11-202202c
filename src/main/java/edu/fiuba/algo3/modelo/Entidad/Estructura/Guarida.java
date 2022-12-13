package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereGuarida;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;
import edu.fiuba.algo3.modelo.Raza.Zerg;

import java.util.ArrayList;

public class Guarida extends Estructura {
    public Guarida(Area area, Zerg zerg, ArrayList<Estructura> estructuras) {
        this();
        raza = zerg;

        //Chequeos
        if (!area.construible(new NoSobreRecurso(), new RangoMoho()) && new RequiereReservaDeReproduccion().construible(estructuras)) {
            throw new ConstruccionNoValidaException();
        }

        try {
            this.area = area.ocupar();
            zerg.gastarRecursos(200, 100);
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        }

        zerg.registrarEntidad(this);
    }

    public Guarida() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(1250, this);
        this.escudo = new SinEscudo(vida);

        this.estadoOperativo = new EnConstruccion(12);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
    }

    @Override
    public boolean permitirCorrelatividad(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}
