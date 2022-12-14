package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Zerg;

public class EvolucionarAGuardian implements Comando {
    private Zerg zerg;
    private Area area;

    public EvolucionarAGuardian(Zerg zerg, Area area) {
        this.zerg = zerg;
        this.area = area;
    }

    @Override
    public void ejecutar() {
        zerg.construirGuardian(area);
    }
}
