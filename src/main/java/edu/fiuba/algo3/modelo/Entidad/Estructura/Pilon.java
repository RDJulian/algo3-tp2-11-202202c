package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.ArrayList;

public class Pilon extends Estructura implements Piso {
    private int rango;

    public Pilon(Posicion posicion, Raza raza, Recurso recurso) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(100, 0);
        this.posicion = posicion.ocupar();

        boolean construible = new NoSobreRecurso().construible(recurso, posicion)
                && new RangoPilon().construible(posicion);

        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        //Instanciacion de clases comunes
        this.vida = new Normal(300);
        this.defensa = new Escudo(300);

        this.estadoOperativo = new EnConstruccion(5);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();

        //Instanciacion de clases especificas a esta entidad
        this.rango = 3;

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
    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, rango);
    }

    @Override
    public boolean construible(ConstruibleEstructura construibleEstructura) {
        return construibleEstructura.visitar(this);
    }
}
