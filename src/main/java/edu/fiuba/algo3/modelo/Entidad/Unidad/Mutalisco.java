package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorDevorador;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorGuardian;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorUnidades;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereEspiral;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.NoAtaca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Entidad.Vida.SinEscudo;

import java.util.ArrayList;

public class Mutalisco extends Unidad {
    public Mutalisco(Area area, Raza raza, ArrayList<Estructura> estructuras) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(50, 0);
        this.area = area.ocupar();

        boolean construible = new RequiereEspiral().construible(estructuras);
        if (!construible) {
            throw new ConstruccionNoValidaException();
        }

        //Instanciacion de clases comunes
        this.vida = new Regenerativa(200);
        this.defensa = new SinEscudo();

        this.estadoOperativo = new EnConstruccion(5);
        this.estadoInvisibilidad = new Invisible();
        this.afectaSuministro = new Proveedor();

        this.tipoUnidad = new UnidadAire();
        this.ataque = new NoAtaca();
        this.contadorDeBajas = 0;

        raza.registarEntidad(this);
    }

    public void evolucionarAGuardian() {
        ConstructorUnidades constructor = ConstructorGuardian.obtenerInstancia();
        raza.registarEntidad(constructor.construir(area));
        destruir();
    }

    public void evolucionarADevorador() {
        ConstructorUnidades constructor = ConstructorDevorador.obtenerInstancia();
        raza.registarEntidad(constructor.construir(area));
        destruir();
    }
}
