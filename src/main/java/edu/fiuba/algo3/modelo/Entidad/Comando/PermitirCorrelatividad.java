package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;

public class PermitirCorrelatividad implements ComandoBool {
    private Estructura estructura;
    private ConstruibleEstructura construibleEstructura;

    public PermitirCorrelatividad(Estructura estructura, ConstruibleEstructura construibleEstructura) {
        this.estructura = estructura;
        this.construibleEstructura = construibleEstructura;
    }

    @Override
    public boolean ejecutar() {
        return estructura.permitirCorrelatividad(construibleEstructura);
    }
}
