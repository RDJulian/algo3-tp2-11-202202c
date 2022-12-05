package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Visible;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Proveedor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Pilon extends Estructura implements Piso {
    private int rango;

    public Pilon(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoOperativo = new EnConstruccion(5);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new Proveedor();
        this.vida = new Normal(300);
        this.defensa = new Escudo(300);
        this.raza = raza;

        this.rango = 3;
    }

    @Override
    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, rango);
    }

    @Override
    public void construible(ConstruiblePiso requierePiso, Posicion posicion) {
        estadoOperativo.operable();
        requierePiso.visitar(this);
        if (fueraDeRango(posicion)) {
            throw new ConstruccionNoValidaException();
        }
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        estadoOperativo.operable();
    }
}
