package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.ArrayList;

public class Guarida extends Estructura {
    public Guarida(Area area, Raza raza, ArrayList<Estructura> estructuras) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(200, 100);


        boolean construible = new NoSobreRecurso().construible(area)
                && new RangoMoho().construible(area)
                && new RequiereReservaDeReproduccion().construible(estructuras);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }
        this.area = area.ocupar();
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(1250);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(12);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        raza.registarEntidad(this);
    }

    public Guarida() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(1250);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(12);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
    }

    @Override
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}
