package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;

public class Nada extends Estructura {

    public Nada() {
        this.rolEnSuministro = new Neutral();
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
    }
}
