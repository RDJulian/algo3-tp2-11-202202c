package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereAcceso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.SinEnergia;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Memento.MementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Memento.UsaMementoOperativo;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.ArrayList;

public class PuertoEstelar extends Estructura implements UsaMementoOperativo {
    private Energia energia;

    public PuertoEstelar(Posicion posicion, Raza raza, Recurso recurso, ArrayList<Estructura> estructuras) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(150, 150);
        this.posicion = posicion.ocupar();

        boolean construible = new NoSobreRecurso().construible(recurso, posicion)
                && new RangoPilon().construible(posicion)
                && new RequiereAcceso().construible(estructuras);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        //Instanciacion de clases comunes
        this.vida = new Normal(600);
        this.defensa = new Escudo(600);

        this.estadoOperativo = new EnConstruccion(10);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.energia = new Energia(this);

        raza.registarEntidad(this);
    }

    public PuertoEstelar() {
        //Instanciacion de clases comunes
        this.vida = new Normal(600);
        this.defensa = new Escudo(600);

        this.estadoOperativo = new EnConstruccion(10);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.energia = new Energia(this);
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
    public void actualizarEstado(ArrayList<Pilon> pilones) {
        energia.actualizarEstado(pilones, posicion);
    }

    @Override
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}
