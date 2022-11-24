package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.ExtraerRecurso;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class NexoMineral extends Estructura implements ExtraeRecurso {
    private Recurso mineral;
    private Raza raza;

    public NexoMineral(Posicion posicion, Recurso mineral, Raza raza) {
        super(posicion);
        this.mineral = mineral;
        mineral.ocupar(this);
        this.raza = raza;
        this.estadoEstructura = new EnConstruccion(4);
        this.vida = new Normal(250);
        this.defensa = new Escudo(250);
        this.accionAlPasarTurno = new ExtraerRecurso(this);
    }

    public void extraerRecurso() {
        mineral.extraerRecurso(20, this.raza, this); //Asumimos 20.
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}
