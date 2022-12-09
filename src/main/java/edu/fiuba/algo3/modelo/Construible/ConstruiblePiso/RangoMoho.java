package edu.fiuba.algo3.modelo.Construible.ConstruiblePiso;

import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.Nada;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RangoMoho extends ConstruiblePiso {
    @Override
    public boolean visitar(Nada nada) {
        return false;
    }

    @Override
    public boolean visitar(TieneEnergiaPilon tieneEnergiaPilon) {
        return false;
    }

    @Override
    public boolean visitar(TieneMoho tieneMoho) {
        return true;
    }
}
