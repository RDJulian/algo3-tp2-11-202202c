package edu.fiuba.algo3.modelo.Construible.ConstruiblePiso;

import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPisoNull;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;

public interface ConstruiblePiso {
    boolean visitar(EstadoPisoNull estadoPisoNull);

    boolean visitar(TieneEnergiaPilon tieneEnergiaPilon);

    boolean visitar(TieneMoho tieneMoho);
}