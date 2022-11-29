package edu.fiuba.algo3.modelo.Vida;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zealot;
import edu.fiuba.algo3.modelo.EstadoEntidad.Destruido;
import edu.fiuba.algo3.modelo.Entidad.Daniable;

public abstract class Vida {

    protected int limite;
    protected int cantVida;

    public Vida(int cantVida) {
        this.cantVida = cantVida;
        this.limite = cantVida;
    }

    public void daniar(Entidad entidad, int danio) {
        int nuevaVida = cantVida - danio;
        if (nuevaVida <= 0) {
            nuevaVida = 0;
            entidad.destruir();
        }
        this.cantVida = nuevaVida;
    }

    public void daniar(Daniable daniable, int danio, Zealot unidadAtacante) {
        int nuevaVida = cantVida - danio;
        if (nuevaVida <= 0) {
            nuevaVida = 0;
            daniable.setEstado(new Destruido());
            unidadAtacante.sumarBaja();
        }
        this.cantVida = nuevaVida;
    }

    public abstract void regenerar();
}
