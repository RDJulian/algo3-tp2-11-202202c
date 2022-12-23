package edu.fiuba.algo3.modelo.Entidad.Defensa.Vida;

import edu.fiuba.algo3.modelo.Entidad.Entidad;

public class Regenerativa extends Vida {

    public Regenerativa(int cantidadVida, Entidad entidad) {
        super(cantidadVida, entidad);
    }

    @Override
    public void regenerar() {
        int nuevaVida = this.cantidadVida + 10; //Se puede cambiar
        if (nuevaVida > limite) {
            nuevaVida = limite;
        }
        this.cantidadVida = nuevaVida;
    }
}
