package edu.fiuba.algo3.modelo.Cubierta;

public class Energizada implements Cubierta{
    private int cantDeEnergia;

    public Energizada(){this.cantDeEnergia = 1;}

    @Override
    public Cubierta energizar() {
        this.cantDeEnergia += 1;
        return this;
    }

    @Override
    public Cubierta cubrirDeMoho() {
        return this;
    }

    @Override
    public int getEnergiaPresente() {
        return cantDeEnergia;
    }
}
