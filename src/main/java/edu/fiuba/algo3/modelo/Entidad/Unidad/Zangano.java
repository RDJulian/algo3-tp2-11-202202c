package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.Daniable;
import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zangano extends Unidad implements ExtraeRecurso {
    private Raza raza;
    private Recurso mineral;

    public Zangano(Posicion posicion) { //Zangano no tiene ataque.
        super(posicion);
        this.radioAtaque = 0;
        this.rangoAtaque = new Rango(this.posicion, this.radioAtaque);
        this.danioAire = 0;
        this.danioTierra = 0;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Regenerativa(25);
        this.defensa = new SinEscudo();
        this.estadoEntidad = new EnConstruccion(1);
    }

    //Un Zangano no ataca, asi que directamente tira excepcion.
    @Override
    public void atacar(Daniable daniable) {
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
