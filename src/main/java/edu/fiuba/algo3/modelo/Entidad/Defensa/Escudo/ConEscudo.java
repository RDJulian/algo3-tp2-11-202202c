package edu.fiuba.algo3.modelo.Entidad.Defensa.Escudo;

import edu.fiuba.algo3.modelo.Entidad.Defensa.Vida.Vida;

public class ConEscudo extends Escudo {

    public ConEscudo(int cantidadEscudo, Vida vida) {
        super(cantidadEscudo, vida);
    }

    @Override
    public void regenerar() {
        int nuevoEscudo = this.cantidadEscudo + 10; //Se puede cambiar.
        if (nuevoEscudo > limite) {
            nuevoEscudo = limite;
        }
        this.cantidadEscudo = nuevoEscudo;
    }
}
