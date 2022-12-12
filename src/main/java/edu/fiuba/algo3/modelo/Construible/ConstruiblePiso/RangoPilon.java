package edu.fiuba.algo3.modelo.Construible.ConstruiblePiso;

import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPisoNull;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;

public class RangoPilon extends ConstruiblePiso {
    @Override
    public boolean visitar(EstadoPisoNull estadoPisoNull) {
        return false;
    }

    @Override
    public boolean visitar(TieneEnergiaPilon tieneEnergiaPilon) {
        return true;
    }

    @Override
    public boolean visitar(TieneMoho tieneMoho) {
        return false;
    }
}
