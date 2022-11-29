package edu.fiuba.algo3.modelo.Vida;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zealot;

public abstract class Defensa {
    protected int cantEscudo;
    protected int limite;

    public Defensa(int cantEscudo) {
        this.cantEscudo = cantEscudo;
        this.limite = cantEscudo;
    }

    public void proteger(Entidad entidad, Vida vida, int danio) {
        int nuevoEscudo = cantEscudo - danio;
        if (nuevoEscudo < 0) {
            vida.daniar(entidad, nuevoEscudo * (-1));
            nuevoEscudo = 0;
        }
        this.cantEscudo = nuevoEscudo;
    }

    public void proteger(Daniable daniable, Vida vida, int danio, Zealot unidadAtacante){
        int nuevoEscudo = cantEscudo - danio;
        if (nuevoEscudo < 0) {
            vida.daniar(daniable, nuevoEscudo * (-1), unidadAtacante);
            nuevoEscudo = 0;
        }
        this.cantEscudo = nuevoEscudo;
    }

    public abstract void regenerar();
}
