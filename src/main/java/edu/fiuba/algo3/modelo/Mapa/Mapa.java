package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Piso.Piso;

import java.util.ArrayList;

public class Mapa {
    private ArrayList<Piso> pisos;
    static Mapa instancia;

    private Mapa() {
        this.pisos = new ArrayList<>();
    }

    static public Mapa obtenerInstancia() {
        if (instancia == null) {
            instancia = new Mapa();
        }
        return instancia;
    }

    public void agregarPiso(Piso piso) {
        pisos.add(piso);
    }
}
