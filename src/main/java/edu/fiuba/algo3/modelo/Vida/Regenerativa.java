package edu.fiuba.algo3.modelo.Vida;

public class Regenerativa extends Vida {

    public Regenerativa(int cantVida) {
        super(cantVida);
    }

    @Override
    public void regenerar() {
        int nuevaVida = this.cantVida + 10; //Se puede cambiar
        if (nuevaVida > limite) {
            nuevaVida = limite;
        }
        this.cantVida = nuevaVida;
    }
}
