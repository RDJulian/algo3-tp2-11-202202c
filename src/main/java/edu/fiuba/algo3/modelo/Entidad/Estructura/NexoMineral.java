package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class NexoMineral extends Estructura implements ExtraeRecurso {
    private Recurso mineral;

    public NexoMineral(Posicion posicion, Recurso mineral, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();
        this.mineral = mineral;
        mineral.ocupar(this);
        this.raza = raza;

        this.estadoEntidad = new EnConstruccion(4);
        this.rolEnSuministro = new Neutral();
        this.vida = new Normal(250);
        this.defensa = new Escudo(250);
    }

    @Override
    public void pasarTurno() {
        try {
            operable();
        } catch (EntidadNoOperativaException exception) {
            this.estadoEntidad = estadoEntidad.pasarTurno(vida, defensa);
            return;
        }
        this.estadoEntidad = estadoEntidad.pasarTurno(vida, defensa);
        extraerRecurso();
    }

    public void extraerRecurso() {
        mineral.extraerRecurso(20, raza, this); //Asumimos 20.
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}
