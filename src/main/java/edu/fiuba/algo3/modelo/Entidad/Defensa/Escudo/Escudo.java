package edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo;

import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Vida;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;

public abstract class Escudo {
    protected int cantidadEscudo;
    protected int limite;

    protected Vida vida;

    public Escudo(int cantidadEscudo, Vida vida) {
        this.cantidadEscudo = cantidadEscudo;
        this.limite = cantidadEscudo;
        this.vida = vida;
    }

    public void proteger(int danio, Unidad unidadAtacante) {
        int nuevoEscudo = cantidadEscudo - danio;
        if (nuevoEscudo < 0) {
            vida.daniar(nuevoEscudo * (-1), unidadAtacante);
            nuevoEscudo = 0;
        }
        this.cantidadEscudo = nuevoEscudo;
    }

    public abstract void regenerar();
}
