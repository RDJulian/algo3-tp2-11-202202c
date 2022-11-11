package edu.fiuba.algo3.modelo.Vida;

public abstract class Vida {

    protected int limite;
    protected int cantVida;

    public Vida(int cantVida){
        this.cantVida = cantVida;
        this.limite = cantVida;
    }

    public void daniar(int danio){
        int nuevaVida = cantVida - danio;
        if (nuevaVida<0){
            nuevaVida = 0;
        }
        this.cantVida = nuevaVida;
    }
    public abstract void regenerar();

    public int getVida() {return this.cantVida;}
}
