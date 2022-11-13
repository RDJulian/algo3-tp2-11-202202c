package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupada;

public class Ocupada implements EstadoPosicion{

    @Override
    public void ocupable() throws PosicionOcupada { throw new PosicionOcupada();}
}
