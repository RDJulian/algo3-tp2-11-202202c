package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zangano extends Unidad implements ExtraeRecurso {
    private Recurso mineral;

    public Zangano(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(1);
        this.rolEnSuministro = new Consumidor(1);
        this.vida = new Regenerativa(25);
        this.defensa = new SinEscudo();

        this.tipoUnidad = new UnidadTierra();
        this.danioTierra = 0;
        this.danioAire = 0;
        this.rangoAtaque = 0;
        this.invisible = false;
        this.contadorDeBajas = 0;

        this.raza = raza;
        this.mineral = new Nada();


    }

    //Ver que hacer con esto. AmoSupremo resuelve igual.
    @Override
    public void atacar(Entidad entidad) {
        throw new AtaqueNoValidoException();
    }

    //Redundante pasarle la misma raza.
    public void usarExtractor(Recurso recurso, ExtraeRecurso extractor) {
        estadoEntidad.operable();
        recurso.extraerRecurso(10, raza, extractor);
    }

    public void extraerRecurso() {
        mineral.extraerRecurso(10, raza, this);
    }

    public void ocupar(Recurso mineral) {
        estadoEntidad.operable();
        mineral.ocupar(this, posicion);
        this.mineral = mineral;
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