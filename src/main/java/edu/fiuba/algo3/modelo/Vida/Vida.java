package edu.fiuba.algo3.modelo.Vida;

import edu.fiuba.algo3.modelo.EstadoEstructura.Destruido;
import edu.fiuba.algo3.modelo.Unidad.Daniable;

public abstract class Vida {

    protected int limite;
    protected int cantVida;

    public Vida(int cantVida) {
        this.cantVida = cantVida;
        this.limite = cantVida;
    }

    public void daniar(Daniable daniable, int danio) {
        int nuevaVida = cantVida - danio;
        if (nuevaVida <= 0) {
            nuevaVida = 0;
            daniable.setEstado(new Destruido());
        }
        this.cantVida = nuevaVida;
    }

    public abstract void regenerar();

    public int getVida() {
        return this.cantVida;
    }
}
