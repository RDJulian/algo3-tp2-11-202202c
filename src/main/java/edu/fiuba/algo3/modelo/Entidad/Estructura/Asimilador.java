package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.SobreGasVespeno;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.ArrayList;

public class Asimilador extends Estructura implements ExtraeRecurso {
    private Recurso recurso;

    public Asimilador(Posicion posicion, Raza raza, Recurso recurso) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(100, 0);
        this.posicion = posicion.ocupar();

        boolean construible = new SobreGasVespeno().construible(recurso, posicion)
                && new RangoPilon().construible(posicion);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        //Instanciacion de clases comunes
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);

        this.estadoOperativo = new EnConstruccion(6);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.recurso = recurso;

        raza.registarEntidad(this);
    }

    public Asimilador() {
        //Instanciacion de clases comunes
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);

        this.estadoOperativo = new EnConstruccion(6);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
    }

    @Override
    public void extraerRecurso() {
        recurso.extraerRecurso(20, this.raza, this);
    }


    @Override
    public void pasarTurno() {
        estadoOperativo.pasarTurno(vida, defensa, new ExtraerRecurso(this));
    }

    @Override
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}