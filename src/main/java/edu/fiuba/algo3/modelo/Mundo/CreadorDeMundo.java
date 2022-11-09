package edu.fiuba.algo3.modelo.Mundo;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.TerrenoLlano;

import java.util.Vector;

public class CreadorDeMundo {

    public Mundo crearMundoLlano(int largo, int ancho){
        Mundo resultado = new Mundo();
        for (int i = 0; i < ancho; i++) {
            Vector<CeldaDeTerreno> celdasLlanas = new Vector();
            TerrenoLlano primerCeldaLlana = new TerrenoLlano();
            celdasLlanas.add(primerCeldaLlana);
            for (int j = 0; j < largo; j++) {
                TerrenoLlano ultCelda = (TerrenoLlano) celdasLlanas.lastElement();
                TerrenoLlano nuevaCelda = new TerrenoLlano();
                ultCelda.expandirPorAbajo(nuevaCelda);
                celdasLlanas.add(nuevaCelda);
            }
            Columna nuevaColumna = new Columna(celdasLlanas);
            resultado.agregar(nuevaColumna);
        }
        return resultado;
    }
}
