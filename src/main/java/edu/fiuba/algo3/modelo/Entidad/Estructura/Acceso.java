package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.SinEnergia;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.Energia;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoOperativo;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Vida.Escudo;
import edu.fiuba.algo3.modelo.Entidad.Vida.Normal;

public class Acceso extends Estructura implements UsaMementoOperativo {
    private Energia energia;

    public Acceso(Area area, Raza raza) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(150, 0);


        boolean construible = new NoSobreRecurso().construible(area)
                && new RangoPilon().construible(area);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        this.area = area.ocupar();
        //Instanciacion de clases comunes
        this.vida = new Normal(500);
        this.defensa = new Escudo(500);

        this.estadoOperativo = new EnConstruccion(8);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.energia = new Energia(this);

        raza.registarEntidad(this);
    }

    public Acceso() {
        //Instanciacion de clases comunes
        this.vida = new Normal(500);
        this.defensa = new Escudo(500);

        this.estadoOperativo = new EnConstruccion(8);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.energia = new Energia(this);
        this.raza = new Raza();
        this.area = new Area(0, 0);
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
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}