package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereGuarida;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.ArrayList;

public class Espiral extends Estructura {
    public Espiral(Posicion posicion, Raza raza, Recurso recurso, ArrayList<Estructura> estructuras) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(150, 100);
        this.posicion = posicion.ocupar();

        boolean construible = new NoSobreRecurso().construible(recurso, posicion)
                && new RangoMoho().construible(posicion)
                && new RequiereGuarida().construible(estructuras);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        //Instanciacion de clases comunes
        this.vida = new Regenerativa(1300);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(10);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        raza.registarEntidad(this);
    }

    public Espiral() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(1300);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(10);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
    }

    @Override
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}