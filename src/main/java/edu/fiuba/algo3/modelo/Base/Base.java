package edu.fiuba.algo3.modelo.Base;

import edu.fiuba.algo3.modelo.Excepciones.BaseNoOpuestaException;
import edu.fiuba.algo3.modelo.Area.Area;

public class Base {
    //Ver como enganchar esta clase con lo demas o si siquiera deberia existir.
    private Area area;

    public Base(Area area) {
        this.area = area;
    }

    public void opuesta(Base otraBase) {
        if (!otraBase.esOpuesta(area)) {
            throw new BaseNoOpuestaException();
        }
    }

    private boolean esOpuesta(Area area) {
        return area.esOpuesta(this.area);
    }
}
