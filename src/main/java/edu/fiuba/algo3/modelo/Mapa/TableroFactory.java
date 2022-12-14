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

        while (tablero.size() < 51) {
            ArrayList<Area> columna = new ArrayList<>();
            while (columna.size() < 51) {
                columna.add(null);
            }
            tablero.add(columna);
        }

        for (int i = -25; i <= 25; i++) {
            for (int j = -25; j <= 25; j++) {
                if (modulo(i) + modulo(j) < 6 || modulo(i) + modulo(j) > 45)
                    tablero.get(i + 25).set(j + 25, new Area(new Coordenada(i, j), new AreaEspacial(), new RecursoNull()));
                else
                    tablero.get(i + 25).set(j + 25, new Area(new Coordenada(i, j), new AreaTierra(), new RecursoNull()));
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
