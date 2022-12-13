package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.SobreMineral;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.ConEscudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Normal;
import edu.fiuba.algo3.modelo.Raza.Zerg;

public class NexoMineral extends Estructura implements ExtraeRecurso, EstructuraNoRequerida {
    public NexoMineral(Area area, Protoss protoss) {
        this();
        raza = protoss;

        //Chequeos
        if (!area.construible(new SobreMineral(), new RangoPilon())) {
            throw new ConstruccionNoValidaException();
        }

        try {
            this.area = area.ocupar();
            protoss.gastarRecursos(50, 0);
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        }

        protoss.registrarEntidad(this);
    }

    public NexoMineral() {
        //Instanciacion de clases comunes
        this.vida = new Normal(250, this);
        this.escudo = new ConEscudo(250, vida);

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
    }

    @Override
    public void extraerRecurso() {
        area.extraerRecurso(20, raza); //Asumimos 20.
    }

    @Override
    public void pasarTurno() {
        estadoOperativo = estadoOperativo.pasarTurno(vida, escudo, new ExtraerRecurso(this));
    }

    @Override
    public boolean permitirCorrelatividad(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}
