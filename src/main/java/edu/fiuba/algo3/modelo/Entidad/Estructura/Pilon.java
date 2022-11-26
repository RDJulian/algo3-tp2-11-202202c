package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.RolEnSuministro.Proveedor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Pilon extends Estructura implements Piso {
    private int rango;

    public Pilon(Posicion posicion) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoEntidad = new EnConstruccion(5);
        this.accionAlPasarTurno = new Nada();
        this.vida = new Normal(300);
        this.defensa = new Escudo(300);

        this.rango = 3;

        this.rolEnSuministro = new Proveedor();
    }

    @Override
    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, rango);
    }

    @Override
    public void construible(ConstruiblePiso requierePiso, Posicion posicion) {
        estadoEntidad.operable();
        requierePiso.visitar(this);
        if (fueraDeRango(posicion)) {
            throw new ConstruccionNoValidaException();
        }
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}
