package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.ComandoNull;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EstadoOperativo;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.SinEnergia;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.ConEscudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Normal;

public class Pilon extends Estructura implements Piso, EstructuraNoRequerida {
    private int rango;

    public Pilon(Area area, Protoss protoss) {
        this();
        raza = protoss;

        //Chequeos
        if (!area.construible(new NoSobreRecurso(), new RangoPilon())) {
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

    public Pilon(Area area) {
        this();
        this.area = area;
    }

    //Exclusivamente para testear.
    public void desenergizar() {
        this.estadoOperativo = new SinEnergia();
    }

    public Pilon() {
        //Instanciacion de clases comunes
        this.vida = new Normal(300, this);
        this.escudo = new ConEscudo(300, vida);

        this.estadoOperativo = new EnConstruccion(5);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new Proveedor();

        //Instanciacion de clases especificas a esta entidad
        this.rango = 3;
    }

    @Override
    public void pasarTurno() {
        EstadoOperativo estadoAnterior = estadoOperativo;
        estadoOperativo = estadoOperativo.pasarTurno(vida, escudo, new ComandoNull());
        if (estadoAnterior != estadoOperativo && area != null) {
            Mapa.obtenerInstancia().agregarPiso(this);
            Mapa.obtenerInstancia().actualizarTablero();
        }
    }

    @Override
    public void actualizarArea(Area area) {
        if (area.enRango(this.area, rango)) {
            area.energizar();
        }
    }

    @Override
    public boolean permitirCorrelatividad(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}
