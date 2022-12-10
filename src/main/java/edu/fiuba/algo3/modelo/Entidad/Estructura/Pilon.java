package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Pilon extends Estructura implements Piso {
    private int rango;

    public Pilon(Area area, Raza raza) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(100, 0);


        boolean construible = new NoSobreRecurso().construible(area)
                && new RangoPilon().construible(area);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }
        this.area = area.ocupar();
        //Instanciacion de clases comunes
        this.vida = new Normal(300);
        this.defensa = new Escudo(300);

        this.estadoOperativo = new EnConstruccion(5);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.rango = 3;
        area.energizar();

        raza.registarEntidad(this);
    }

    public Pilon() {
        //Instanciacion de clases comunes
        this.vida = new Normal(300);
        this.defensa = new Escudo(300);

        this.estadoOperativo = new EnConstruccion(5);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.rango = 3;
    }

    @Override
    public void actualizarPosicionEnRango(Area area) {
        if (area.enRango(this.area, rango)) {
            area.energizar();
        }
    }

    @Override
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}
