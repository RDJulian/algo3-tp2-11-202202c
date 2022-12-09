package edu.fiuba.algo3.modelo.Construible.ConstruiblePiso;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.Nada;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public abstract class ConstruiblePiso {
    public boolean construible(Posicion posicion) {
        return posicion.construible(this);
    }

    public abstract boolean visitar(Nada nada);

    public abstract boolean visitar(TieneEnergiaPilon tieneEnergiaPilon);

    public abstract boolean visitar(TieneMoho tieneMoho);
}