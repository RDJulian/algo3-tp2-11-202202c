package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereGuarida;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Entidad.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Vida.SinEscudo;

import java.util.ArrayList;

public class Espiral extends Estructura {
    public Espiral(Area area, Raza raza, ArrayList<Estructura> estructuras) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(150, 100);


        boolean construible = new NoSobreRecurso().construible(area)
                && new RangoMoho().construible(area)
                && new RequiereGuarida().construible(estructuras);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }
        this.area = area.ocupar();
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
        this.raza = new Raza();
        this.area = new Area(0, 0);
    }

    @Override
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}