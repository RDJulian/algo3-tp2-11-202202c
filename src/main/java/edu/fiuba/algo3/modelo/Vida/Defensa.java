package edu.fiuba.algo3.modelo.Vida;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Unidad.Unidad;

public abstract class Defensa {
    protected int cantEscudo;
    protected int limite;

    public Defensa(int cantEscudo) {
        this.cantEscudo = cantEscudo;
        this.limite = cantEscudo;
    }


    //Se deberia juntar.
    public void proteger(Estructura estructura, Vida vida, int danio) {
        int nuevoEscudo = cantEscudo - danio;
        if (nuevoEscudo < 0) {
            vida.daniar(estructura, nuevoEscudo * (-1));
            nuevoEscudo = 0;
        }
        this.cantEscudo = nuevoEscudo;
    }

    public void proteger(Unidad unidad, Vida vida, int danio) {
        int nuevoEscudo = cantEscudo - danio;
        if (nuevoEscudo < 0) {
            vida.daniar(unidad, nuevoEscudo * (-1));
            nuevoEscudo = 0;
        }
        this.cantEscudo = nuevoEscudo;
    }

    public abstract void regenerar();

    public int getDefensa() {
        return this.cantEscudo;
    }

}
