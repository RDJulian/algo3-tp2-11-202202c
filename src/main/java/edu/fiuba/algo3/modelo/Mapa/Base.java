package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Excepciones.BaseNoOpuestaException;

import java.util.ArrayList;

public class Base {
    private final int posicionX;
    private final int posicionY;
    private final Coordenada coordenada;

    public Base(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.coordenada = new Coordenada(posicionX, posicionY);
    }

    public void generarBase(ArrayList<ArrayList<Area>> tablero) {
        tablero.get(posicionX + 25).set(posicionY + 25, new Area(new Coordenada(posicionX, posicionY), new AreaTierra(), new GasVespeno()));
        tablero.get(posicionX + 27).set(posicionY + 25, new Area(new Coordenada(posicionX + 2, posicionY), new AreaTierra(), new GasVespeno()));
        tablero.get(posicionX + 23).set(posicionY + 25, new Area(new Coordenada(posicionX - 2, posicionY), new AreaTierra(), new GasVespeno()));
        tablero.get(posicionX + 25).set(posicionY + 27, new Area(new Coordenada(posicionX, posicionY + 2), new AreaTierra(), new GasVespeno()));
        tablero.get(posicionX + 25).set(posicionY + 23, new Area(new Coordenada(posicionX, posicionY - 2), new AreaTierra(), new GasVespeno()));
    }

    private boolean esOpuesta(Coordenada coordenada) {
        return coordenada.esOpuesta(this.coordenada);
    }

    public void opuesta(Base base) {
        if (!base.esOpuesta(coordenada)) {
            throw new BaseNoOpuestaException();
        }
    }
}
