package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.NoAtaca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zangano extends Unidad implements ExtraeRecurso {
    private Recurso mineral;

    public Zangano(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoOperativo = new EnConstruccion(1);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new Consumidor(1);
        this.vida = new Regenerativa(25);
        this.defensa = new SinEscudo();

        this.tipoUnidad = new UnidadTierra();
        this.ataque = new NoAtaca();

        this.raza = raza;
        this.mineral = new Nada();


    }

    public void usarExtractor(Recurso recurso, ExtraeRecurso extractor) {
        estadoOperativo.operable();
        recurso.extraerRecurso(10, raza, extractor);
    }

    public void extraerRecurso() {
        mineral.extraerRecurso(10, raza, this);
    }

    public void ocupar(Recurso mineral) {
        estadoOperativo.operable();
        mineral.ocupar(this, posicion);
        this.mineral = mineral;
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