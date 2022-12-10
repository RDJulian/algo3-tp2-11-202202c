package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereCriadero;
import edu.fiuba.algo3.modelo.Entidad.Comando.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.Comando.UsarExtractor;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.NoAtaca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Vida.SinEscudo;

import java.util.ArrayList;

public class Zangano extends Unidad implements ExtraeRecurso {

    public Zangano(Area area, Raza raza, ArrayList<Estructura> estructuras) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(50, 0);
        this.area = area.ocupar();

        boolean construible = new RequiereCriadero().construible(estructuras);
        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        //Instanciacion de clases comunes
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(1);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();

        this.tipoUnidad = new UnidadAire();
        this.ataque = new NoAtaca();
        this.contadorDeBajas = 0;

        raza.registarEntidad(this);
    }

    //Constructor para testear.
    public Zangano() {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(1);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();

        this.tipoUnidad = new UnidadAire();
        this.ataque = new NoAtaca();
        this.contadorDeBajas = 0;
        this.area = new Area(0, 0);
    }

    //Constructor para testear.
    public Zangano(Raza raza) {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(1);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();

        this.tipoUnidad = new UnidadAire();
        this.ataque = new NoAtaca();
        this.contadorDeBajas = 0;

        this.raza = raza;
    }

    //Constructor para testear.
    public Zangano(Raza raza, Area area) {
        //Instanciacion de clases comunes
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(1);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();

        this.tipoUnidad = new UnidadAire();
        this.ataque = new NoAtaca();
        this.contadorDeBajas = 0;

        this.raza = raza;
        this.area = area.ocupar();
    }

    public void usarExtractor(Area area) {
        estadoOperativo.operable(new UsarExtractor(area, raza));
    }

    public void extraerRecurso() {
        area.extraerRecurso(10, raza);
    }


    @Override
    public void pasarTurno() {
        estadoOperativo = estadoOperativo.pasarTurno(vida, defensa, new ExtraerRecurso(this));
    }
}