package edu.fiuba.algo3.modelo.Vida;

public class Escudo extends Defensa {

    public Escudo(int cantEscudo) {
        super(cantEscudo);
    }

    @Override
    public void regenerar() {
        int nuevoEscudo = this.cantEscudo + 10; //Se puede cambiar.
        if (nuevoEscudo > limite) {
            nuevoEscudo = limite;
        }
        this.cantEscudo = nuevoEscudo;
    }
}
