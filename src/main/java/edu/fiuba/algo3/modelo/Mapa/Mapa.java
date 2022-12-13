package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;

import java.util.ArrayList;

public class Mapa {
    private ArrayList<ArrayList<Area>> tablero;
    private ArrayList<Piso> pisos;
    private ArrayList<Moho> moho;
    static Mapa instancia;

    private Mapa() {
        this.pisos = new ArrayList<>();
        this.moho = new ArrayList<>();
        this.tablero = new TableroFactory().generarTablero();
    }

    static public Mapa obtenerInstancia() {
        if (instancia == null) {
            instancia = new Mapa();
        }
        return instancia;
    }

    public void generarBases(Base unaBase, Base otraBase) {
        new TableroFactory().generarBases(tablero, unaBase, otraBase);
    }

    public void pasarTurno() {
        for (Moho moho : this.moho) {
            moho.pasarTurno();
        }
    }

    public void actualizarTablero() {
        for (ArrayList<Area> areas : tablero) {
            for (Area area : areas)
                area.actualizarEstado(pisos);
        }
    }

    public void agregarPiso(Piso piso) {
        pisos.add(piso);
    }

    public void agregarPiso(Moho moho) {
        pisos.add(moho);
        this.moho.add(moho);
    }

    public Area getArea(int i, int j) {
        return tablero.get(i + 25).get(j + 25);
    }
}
