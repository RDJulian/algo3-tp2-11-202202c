package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;

public class Nada extends Estructura {
    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
    }
}
