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

public class Asimilador extends Estructura implements ExtraeRecurso {
    private Recurso gasVespeno;

    public Asimilador(Posicion posicion, Recurso gasVespeno, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();
        this.gasVespeno = gasVespeno;
        gasVespeno.ocupar(this);
        this.raza = raza;

        this.estadoEntidad = new EnConstruccion(6);
        this.rolEnSuministro = new Neutral();
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);
    }

    @Override
    public void extraerRecurso() {
        gasVespeno.extraerRecurso(20, this.raza, this);
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        estadoEntidad.operable();
    }

    @Override
    public void pasarTurno() {
        try {
            estadoEntidad.operable();
            extraerRecurso();
            estadoEntidad = estadoEntidad.pasarTurno(vida, defensa);
        } catch (EntidadNoOperativaException exception) {
            estadoEntidad = estadoEntidad.pasarTurno(vida, defensa);
        }
    }
}