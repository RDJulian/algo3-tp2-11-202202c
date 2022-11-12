package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class NoNecesitaRango implements ConstruibleSobreRango {
    //Esto puede dar problemas en el caso de que una estructura Protoss se quiera construir en Moho

    @Override
    public void construible(Piso piso, Posicion posicion) {

    }

    @Override
    public void construirEnPilon() {

    }

    @Override
    public void construirEnMoho() {

    }
}
