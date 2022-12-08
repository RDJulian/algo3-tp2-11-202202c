package edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Comando.AgregarZangano;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
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
        this.gasVespeno = gasVespeno;
        gasVespeno.ocupar(this, posicion);
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
        estadoOperativo.operable(new AgregarZangano(zanganos, zangano));
    }

    @Override
    public void pasarTurno() {
        estadoOperativo.pasarTurno(vida, defensa, new ExtraerRecurso(this));
    }
}