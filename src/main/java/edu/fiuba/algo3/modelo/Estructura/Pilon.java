package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
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
    }

    @Override
    public void pasarTurnoOperativo() {
    }

    //No esta tan bueno usar operable dos veces, pero lo dejo por si se accede directamente a fueraDeRango.
    //No se deberia poder considerar el rango si no esta operativa.
    public boolean fueraDeRango(Posicion posicion) {
        this.estadoEstructura.operable();
        return this.rango.noIncluye(posicion);
    }

    @Override
    public void construible(Construible sobreRango, Posicion posicion) {
        this.estadoEstructura.operable();
        sobreRango.manejar(Pilon.class);
        if (fueraDeRango(posicion)) {
            throw new ConstruccionNoValidaException();
        }
    }

    @Override
    public void construible(Construible requiereOtraEstructura) {
        requiereOtraEstructura.manejar(Pilon.class);
    }
}
