package edu.fiuba.algo3.modelo.Cubierta;

public class Natural implements Cubierta{
    @Override
    public Cubierta energizar() {
        return new Energizada();
    }

    @Override
    public Cubierta cubrirDeMoho() {
        return new ConMoho();
    }

    @Override
    public int getEnergiaPresente() {
        return 0;
    }
}
