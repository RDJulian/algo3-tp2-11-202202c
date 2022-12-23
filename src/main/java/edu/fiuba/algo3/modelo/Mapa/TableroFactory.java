package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaEspacial;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;

import java.util.ArrayList;

public class TableroFactory {
    private int modulo(int numero) {
        if (numero < 0) {
            numero = numero * (-1);
        }
        return numero;
    }

    public ArrayList<ArrayList<Area>> generarTablero() {
        ArrayList<ArrayList<Area>> tablero = new ArrayList<>();

        while (tablero.size() <= 51) {
            ArrayList<Area> columna = new ArrayList<>();
            while (columna.size() <= 51) {
                columna.add(null);
            }
            tablero.add(columna);
        }

        for (int x = -25; x <= 25; x++) {
            for (int y = -25; y <= 25; y++) {
                if (modulo(x) + modulo(y) < 6 || modulo(x) + modulo(y) > 45)
                    tablero.get(x + 25).set(50 - (y + 25), new Area(new Coordenada(x, y), new AreaEspacial(), new RecursoNull()));
                else
                    tablero.get(x + 25).set(50 - (y + 25), new Area(new Coordenada(x, y), new AreaTierra(), new RecursoNull()));
            }
        }

        return tablero;
    }

    public void generarBases(ArrayList<ArrayList<Area>> tablero, Base unaBase, Base otraBase) {
        unaBase.opuesta(otraBase);

        unaBase.generarBase(tablero);
        otraBase.generarBase(tablero);
    }
}
