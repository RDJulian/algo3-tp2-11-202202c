package edu.fiuba.algo3.modelo.Mundo;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;

import java.util.Vector;

public class Cuadricula {

    private CeldaDeTerreno centro;
    private int filaOrigen;
    private int radio;
    private Vector<Columna> columnas;

    public Cuadricula(int filaOrigen, CeldaDeTerreno centro, Columna columnaOrigen) {
        this.filaOrigen = filaOrigen;
        this.centro = centro;
        this.radio = 0;
        this.columnas = new Vector();
        this.columnas.add(columnaOrigen);
    }

    public void expandir() {
        for (Columna columna: this.columnas) {
            columna.expandir();
        }
        int nuevoRadio = this.radio + 1;
        Columna primerColumna = this.columnas.firstElement();
        Columna nuevaColumnaIzq = primerColumna.getColumnaIzquierda().getColumnaRecortada(filaOrigen-1-nuevoRadio,filaOrigen+nuevoRadio);
        Columna ultimaColumna = this.columnas.lastElement();
        Columna nuevaColumnaDer = ultimaColumna.getColumnaDerecha().getColumnaRecortada(filaOrigen-1-nuevoRadio,filaOrigen+nuevoRadio);
        primerColumna.expandirPorIzquierda(nuevaColumnaIzq);
        ultimaColumna.expandirPorDerecha(nuevaColumnaDer);
        this.columnas.insertElementAt(nuevaColumnaIzq, 0);
        this.columnas.add(nuevaColumnaDer);
        this.radio = nuevoRadio;
    }

    public CeldaDeTerreno verificarCompatibilidad(CompatibilidadDeTerreno compatibilidad) {
        return this.centro.verificarCompatibilidad(compatibilidad);
    }

    public void energizar() {
        for (Columna columna: this.columnas) {columna.energizar();}
    }
}
