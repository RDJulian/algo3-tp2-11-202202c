package edu.fiuba.algo3.modelo.Mundo;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;

import java.util.Vector;

public class Columna {

    private Vector<CeldaDeTerreno> celdas;
    private Columna columnaIzquierda;
    private Columna columnaDerecha;

    public Columna(Vector<CeldaDeTerreno> celdas) {
        this.celdas = celdas;
    }

    public void expandirPorDerecha(Columna nuevaColumna) {
        this.columnaDerecha = nuevaColumna;
        nuevaColumna.setColumnaIzquierda(this);
    }

    private void setColumnaIzquierda(Columna columna) {
        this.columnaIzquierda = columna;
    }
}
