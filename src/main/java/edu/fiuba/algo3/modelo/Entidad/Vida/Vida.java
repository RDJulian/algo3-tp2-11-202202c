package edu.fiuba.algo3.modelo.Entidad.Vida;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;

public abstract class Vida {

    protected int limite;
    protected int cantVida;

    public Vida(int cantVida) {
        this.cantVida = cantVida;
        this.limite = cantVida;
    }

    public void daniar(Entidad entidad, int danio, Unidad unidadAtacante) {
        int nuevaVida = cantVida - danio;
        if (nuevaVida <= 0) {
            nuevaVida = 0;
            entidad.destruir();
            unidadAtacante.sumarBaja();
        }
        this.cantVida = nuevaVida;
    }

    public abstract void regenerar();
}
