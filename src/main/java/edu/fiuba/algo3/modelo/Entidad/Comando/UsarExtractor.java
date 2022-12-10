package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class UsarExtractor implements Comando {
    private Area area;
    private Raza raza;

    public UsarExtractor(Area area, Raza raza) {
        this.area = area;
        this.raza = raza;
    }

    @Override
    public void ejecutar() {
        area.extraerRecurso(10, raza);
    }
}
