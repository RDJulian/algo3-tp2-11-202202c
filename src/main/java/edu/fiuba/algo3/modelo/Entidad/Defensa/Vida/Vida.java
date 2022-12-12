package edu.fiuba.algo3.modelo.Entidad.Defensa.Vida;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;

public abstract class Vida {
    protected int cantidadVida;
    protected int limite;

    protected Entidad entidad;

    public Vida(int cantidadVida, Entidad entidad) {
        this.cantidadVida = cantidadVida;
        this.limite = cantidadVida;
        this.entidad = entidad;
    }

    public void daniar(int danio, Unidad unidadAtacante) {
        int nuevaVida = cantidadVida - danio;
        if (nuevaVida <= 0) {
            nuevaVida = 0;
            entidad.destruir();
            unidadAtacante.sumarBaja();
        }
        this.cantidadVida = nuevaVida;
    }

    public abstract void regenerar();
}
