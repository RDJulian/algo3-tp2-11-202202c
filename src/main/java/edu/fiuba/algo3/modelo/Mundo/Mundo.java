package edu.fiuba.algo3.modelo.Mundo;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;

import java.util.Vector;

public class Mundo {

    Vector<Columna> columnas;

    public Mundo(){this.columnas = new Vector();}

    public void agregar(Columna nuevaColumna) {
        if (!columnas.isEmpty()) {
            Columna ultColumna = columnas.lastElement();
            ultColumna.expandirPorDerecha(nuevaColumna);
        }
        columnas.add(nuevaColumna);
    }

    public Cuadricula getCuadricula(int fila, int columna, int radio) {
        Columna columnaRecortada = columnas.get(columna-1).getColumnaRecortada(fila-1,fila);
        Cuadricula resultado = new Cuadricula(fila, this.getCelda(fila,columna), columnaRecortada);
        for (int i = 0; i < radio; i++) {
            resultado.expandir();
        }
        return resultado;
    }

    public CeldaDeTerreno getCelda(int fila, int columna){
        Columna columnaCelda = columnas.get(columna-1);
        CeldaDeTerreno celda = columnaCelda.getCelda(fila);
        return celda;
    }
}
