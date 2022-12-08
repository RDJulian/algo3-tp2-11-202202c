package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class NexoMineral extends Estructura implements ExtraeRecurso {
    private Recurso mineral;

    public NexoMineral(Posicion posicion, Recurso mineral, Raza raza) {
        this.posicion = posicion;
        this.mineral = mineral;
        mineral.ocupar(this, posicion);
        this.raza = raza;

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
        this.vida = new Normal(250);
        this.defensa = new Escudo(250);
    }

    @Override
    public void extraerRecurso() {
        mineral.extraerRecurso(20, raza, this); //Asumimos 20.
    }

    @Override
    public void pasarTurno() {
        estadoOperativo.pasarTurno(vida, defensa, new ExtraerRecurso(this));
    }
}
