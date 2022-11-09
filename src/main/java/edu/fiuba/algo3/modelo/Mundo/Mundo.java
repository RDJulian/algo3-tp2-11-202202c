package edu.fiuba.algo3.modelo.Mundo;

import java.util.Vector;

public class Mundo {

    Vector<Columna> columnas;

    public void agregar(Columna nuevaColumna) {
        if (columnas.size() > 0) {
            Columna ultColumna = columnas.lastElement();
            ultColumna.expandirPorDerecha(nuevaColumna);
        }
        columnas.add(nuevaColumna);
    }
}
