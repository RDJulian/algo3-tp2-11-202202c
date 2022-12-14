package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequierePuertoEstelar;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.RevelarEntidad;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.ConEscudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Normal;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EstadoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;

import java.util.ArrayList;

public class Scout extends Unidad implements RevelaEntidades {
    private int radioDeDeteccion;

    public Scout(Area area, ArrayList<Estructura> estructuras, Protoss protoss) {
        this();
        raza = protoss;

        //Chequeos
        if (protoss.suministroRestante() < 4) {
            throw new SuministroInsuficienteException();
        }

        if (!(area.construible(new NoSobreRecurso(), new RangoPilon()) && new RequierePuertoEstelar().construible(estructuras))) {
            throw new ConstruccionNoValidaException();
        }

        try {
            this.area = area.ocupar();
            protoss.gastarRecursos(300, 150);
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        }

        protoss.registrarEntidad(this);
    }

    public Scout(Area area) {
        this();
        this.area = area;
    }

    public Scout() {
        //Instanciacion de clases comunes
        this.vida = new Normal(150, this);
        this.escudo = new ConEscudo(100, vida);

        this.estadoOperativo = new EnConstruccion(9);
        this.estadoInvisibilidadEntidad = new Visible();
        this.afectaSuministro = new Consumidor(4);

        this.tipoUnidad = new UnidadAire();
        this.ataque = new Ataca(this, 8, 14, 4);
        this.contadorDeBajas = 0;

        //Instanciacion de clases especificas a esta entidad
        this.radioDeDeteccion = 4;
    }

    @Override
    public void pasarTurno() {
        EstadoOperativo estadoAnterior = estadoOperativo;
        super.pasarTurno();
        if (estadoAnterior != estadoOperativo && raza != null) {
            raza.revelarContrincante();
        }
    }

    @Override
    public boolean revelar(Area area) {
        return estadoOperativo.operable(new RevelarEntidad(area, this.area, radioDeDeteccion));
    }

    @Override
    public void moverse(Area area) {
        super.moverse(area);

        if (raza != null) {
            raza.revelarContrincante();
        }
    }
}

