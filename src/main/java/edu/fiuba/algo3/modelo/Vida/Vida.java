package edu.fiuba.algo3.modelo.Vida;

import edu.fiuba.algo3.modelo.EstadoEstructura.Destruido;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Unidad.Unidad;

public abstract class Vida {

    protected int limite;
    protected int cantVida;

    public Vida(int cantVida) {
        this.cantVida = cantVida;
        this.limite = cantVida;
    }


    //Se deberia juntar
    public void daniar(Estructura estructura, int danio) {
        int nuevaVida = cantVida - danio;
        if (nuevaVida <= 0) {
            nuevaVida = 0;
            estructura.setEstadoOperativo(new Destruido());
        }
        this.cantVida = nuevaVida;
    }

    public void daniar(Unidad unidad, int danio) {
        int nuevaVida = cantVida - danio;
        if (nuevaVida <= 0) {
            nuevaVida = 0;
            unidad.setEstadoOperativo(new Destruido());
        }
        this.cantVida = nuevaVida;
    }

    public abstract void regenerar();

    public int getVida() {
        return this.cantVida;
    }
}
