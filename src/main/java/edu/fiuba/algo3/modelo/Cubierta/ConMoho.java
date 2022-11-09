package edu.fiuba.algo3.modelo.Cubierta;

public class ConMoho implements Cubierta{

    @Override
    public Cubierta energizar() {
        return this;
    }

    @Override
    public Cubierta cubrirDeMoho() {
        return this;
    }

    @Override
    public int getEnergiaPresente() {
        return 0;
    }
}
