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

    public void setColumnaIzquierda(Columna columna) {
        this.columnaIzquierda = columna;
    }

    public void expandirPorIzquierda(Columna nuevaColumna) {
        this.columnaIzquierda = nuevaColumna;
        nuevaColumna.setColumnaDerecha(this);
    }

    public void setColumnaDerecha(Columna columna) {
        this.columnaDerecha = columna;
    }

    public CeldaDeTerreno getCelda(int fila) {
        return celdas.get(fila-1);
    }

    public void expandir() {
        CeldaDeTerreno celdaSup = this.celdas.firstElement().getCeldaSuperior();
        CeldaDeTerreno celdaInf = this.celdas.lastElement().getCeldaInferior();
        celdas.insertElementAt(celdaSup,0);
        celdas.add(celdaInf);
    }

    public Columna getColumnaRecortada(int desde, int hasta) {
        Vector<CeldaDeTerreno> celdasColumnaRecortada = new Vector();
        for (int i = desde; i < hasta; i++) {celdasColumnaRecortada.add(this.celdas.get(i));}
        Columna resultado = new Columna(celdasColumnaRecortada);
        resultado.setColumnaIzquierda(this.columnaIzquierda);
        resultado.setColumnaDerecha(this.columnaDerecha);
        return resultado;
    }

    public Columna getColumnaIzquierda() {return this.columnaIzquierda;}

    public Columna getColumnaDerecha() {return this.columnaDerecha;}

    public void energizar() {
        for (CeldaDeTerreno celda: this.celdas) {celda.energizar();}
    }
}
