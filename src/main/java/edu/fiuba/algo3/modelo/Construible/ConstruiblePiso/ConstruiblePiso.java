package edu.fiuba.algo3.modelo.Construible.ConstruiblePiso;

import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPisoNull;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Area;

public abstract class ConstruiblePiso {
    public boolean construible(Area area) {
        return area.construible(this);
    }

    public abstract boolean visitar(EstadoPisoNull estadoPisoNull);

    public abstract boolean visitar(TieneEnergiaPilon tieneEnergiaPilon);

    public abstract boolean visitar(TieneMoho tieneMoho);
}