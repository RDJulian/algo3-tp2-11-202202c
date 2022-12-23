package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.mvc.Observable;

import java.util.ArrayList;

public class Mapa extends Observable {
    private ArrayList<ArrayList<Area>> tablero;
    private ArrayList<Piso> pisos;
    private ArrayList<Moho> moho;

    private Mapa() {
        this.pisos = new ArrayList<>();
        this.moho = new ArrayList<>();
        this.tablero = new TableroFactory().generarTablero();
    }

    private static class Holder {
        private static Mapa INSTANCE = new Mapa();
    }

    static public Mapa obtenerInstancia() {
        return Holder.INSTANCE;
    }

    public void generarBases(Base unaBase, Base otraBase) {
        new TableroFactory().generarBases(tablero, unaBase, otraBase);
    }

    public void agregarPiso(Piso piso) {
        pisos.add(piso);
    }

    public void agregarPiso(Moho moho) {
        pisos.add(moho);
        this.moho.add(moho);
    }

    //Resultado de que el mapa tenga todos los Moho.
    public void pasarTurno() {
        for (Moho moho : this.moho) {
            moho.pasarTurno();
        }
    }

    //Fix rapido, pero no deberia haber areas nulas.
    public void actualizarTablero() {
        for (ArrayList<Area> areas : tablero) {
            for (Area area : areas) {
                if (area != null) {
                    area.actualizarEstado(pisos);
                }
            }
        }
    }

    //Hardcodeado.
    public Area getArea(int x, int y) {
        return tablero.get(x + 25).get(50 - (y + 25));
    }
}
