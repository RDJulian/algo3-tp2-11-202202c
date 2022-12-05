package edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Extractor extends Estructura implements ExtraeRecurso {
    private Zanganos zanganos;
    private Recurso gasVespeno;

    public Extractor(Posicion posicion, Recurso gasVespeno, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();
        this.gasVespeno = gasVespeno;
        gasVespeno.ocupar(this);
        this.raza = raza;

        this.estadoOperativo = new EnConstruccion(6);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
        this.vida = new Regenerativa(750);
        this.defensa = new SinEscudo();

        this.zanganos = new Zanganos();
    }

    @Override
    public void extraerRecurso() {
        zanganos.extraerRecurso(gasVespeno, this);
    }

    public void agregarZangano(Zangano zangano) {
        estadoOperativo.operable();
        zanganos.agregarZangano(zangano);
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