package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
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

        this.estadoOperativo = new EnConstruccion(6);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
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
        estadoOperativo.operable();
    }

    @Override
    public void pasarTurno() {
        try {
            estadoOperativo.operable();
            extraerRecurso();
            estadoOperativo = estadoOperativo.pasarTurno(vida, defensa);
        } catch (EntidadNoOperativaException exception) {
            estadoOperativo = estadoOperativo.pasarTurno(vida, defensa);
        }
    }
}