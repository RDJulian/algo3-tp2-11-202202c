package edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo;

import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Vida;

public class SinEscudo extends Escudo {

    public SinEscudo(Vida vida) {
        super(0, vida);
    }

    @Override
    public void regenerar() {
    }
}
