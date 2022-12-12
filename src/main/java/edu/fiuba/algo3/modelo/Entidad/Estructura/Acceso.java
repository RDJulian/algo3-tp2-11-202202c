package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.SinEscudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.SinEnergia;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.Energia;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Zanganos;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo.UsaMementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo.ConEscudo;
import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Normal;

public class Acceso extends Estructura implements UsaMementoOperativo {
    private Energia energia;

    public Acceso(Area area, Raza raza) {
        //Chequeos
        try {
            this.area = area.ocupar();
        } catch (PosicionOcupadaException e) {
            throw new ConstruccionNoValidaException();
        }

        try {
            raza.gastarRecursos(150, 0);
        } catch (RecursoInsuficienteException e) {
            area.desocupar();
            throw new ConstruccionNoValidaException();
        }

        boolean construible = new NoSobreRecurso().construible(area)
                && new RangoPilon().construible(area);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        //Instanciacion de clases comunes
        this.raza = raza;
        this.vida = new Normal(500, this);
        this.escudo = new ConEscudo(500, vida);

        this.estadoOperativo = new EnConstruccion(8);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.energia = new Energia(this);

        raza.registarEntidad(this);
    }

    @Override
    public MementoOperativo guardarEstado() {
        MementoOperativo snapshot = new MementoOperativo(estadoOperativo);
        this.estadoOperativo = new SinEnergia();
        return snapshot;
    }

    @Override
    public void restaurarEstado(MementoOperativo snapshot) {
        this.estadoOperativo = snapshot.restaurar();
    }


    @Override
    public void actualizarEstado() {
        energia.actualizarEstado(area);
    }

    @Override
    public boolean permitirCorrelatividad(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}