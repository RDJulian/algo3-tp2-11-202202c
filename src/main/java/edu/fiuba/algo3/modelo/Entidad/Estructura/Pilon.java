package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Pilon extends Estructura implements Piso {
    private Rango rango;

    public Pilon(Posicion posicion) {
        super(posicion);
        this.rango = new Rango(this.posicion, 3);
        this.estadoEstructura = new EnConstruccion(5);
        this.vida = new Normal(300);
        this.defensa = new Escudo(300);
        this.accionAlPasarTurno = new Nada();
    }

    //No esta tan bueno usar operable dos veces, pero lo dejo por si se accede directamente a fueraDeRango.
    //No se deberia poder considerar el rango si no esta operativa.
    @Override
    public boolean fueraDeRango(Posicion posicion) {
        this.estadoEstructura.operable();
        return this.rango.noIncluye(posicion);
    }

    @Override
    public void construible(ConstruiblePiso sobreRango, Posicion posicion) {
        this.estadoEstructura.operable();
        sobreRango.visitar(this);
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
