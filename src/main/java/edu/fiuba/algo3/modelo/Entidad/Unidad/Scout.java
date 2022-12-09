package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereAcceso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequierePuertoEstelar;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.NoAtaca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.ArrayList;

public class Scout extends Unidad implements RevelaEntidades {
    private int radioDeDeteccion;

    public Scout(Posicion posicion, Raza raza, ArrayList<Estructura> estructuras) {
        //Chequeos
        this.raza = raza;
        raza.gastarRecursos(50, 0);
        this.posicion = posicion.ocupar();

        boolean construible = new RequierePuertoEstelar().construible(estructuras);
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

        //Instanciacion de clases especificas a esta entidad
        this.radioDeDeteccion = 4;

        raza.registarEntidad(this);
    }

    @Override
    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, radioDeDeteccion);
    }
}
