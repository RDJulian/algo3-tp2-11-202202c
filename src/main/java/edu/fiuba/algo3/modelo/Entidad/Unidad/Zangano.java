package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zangano extends Unidad implements ExtraeRecurso {
    private Raza raza;
    private Recurso mineral;

    public Zangano(Posicion posicion) { //Zangano no tiene ataque.
        this.posicion = posicion;
        this.rangoAtaque = 0;
        this.danioAire = 0;
        this.danioTierra = 0;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Regenerativa(25);
        this.defensa = new SinEscudo();
        this.estadoEntidad = new EnConstruccion(1);
        this.accionAlPasarTurno = new ExtraerRecurso(this);
        this.mineral = new Nada();
    }

    //Un Zangano no ataca, asi que directamente tira excepcion.
    @Override
    public void atacar(Entidad entidad) {
        throw new AtaqueNoValidoException();
    }

    //Redundante pasarle la misma raza.
    public void usarExtractor(Recurso recurso, Raza raza, ExtraeRecurso extractor) {
        recurso.extraerRecurso(10, raza, extractor);
    }

    public void extraerRecurso() {
        this.mineral.extraerRecurso(10, this.raza, this);
    }

    public void ocupar(Recurso mineral) {
        mineral.ocupar(this);
        this.mineral = mineral;
    }

    //Dejo este setter por el momento para no tener que cambiar tanto los tests.
    public void setRaza(Raza zerg) {
        this.raza = zerg;
    }
}
