package edu.fiuba.algo3.modelo.Construible.ConstruiblePiso;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.Nada;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public class RangoPilon extends ConstruiblePiso {
    @Override
    public boolean visitar(Nada nada) {
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
