package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Moho implements Piso {
    private int turnos;
    private int rango;

    private Posicion posicion;

    public Moho(Posicion posicion) {
        this.rango = 5;
        this.turnos = 0;
        this.posicion = posicion;
    }

    public boolean fueraDeRango(Posicion posicion) {
        return !posicion.enRango(this.posicion, rango);
    }

    @Override
    public void construible(ConstruiblePiso sobreRango, Posicion posicion) {
        sobreRango.visitar(this);
        if (fueraDeRango(posicion)) {
            throw new ConstruccionNoValidaException();
        }
    }

    //Replantear este funcionamiento.
    //Expansion del moho. Deberia conectarse con expandible o con las areas.
    //expandible() podria hacer el chequeo tanto con la posicion como con el area.
    public void pasarTurno() {
        turnos += 1;
        if (turnos % 2 == 0) {
            this.rango += 1;
        }
    }

    //Replantear solucion.
    public void expandible(Posicion posicion) {

    }
}
