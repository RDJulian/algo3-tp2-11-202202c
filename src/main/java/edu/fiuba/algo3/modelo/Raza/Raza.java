package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Excepciones.RazaZergSinLarvasException;
import edu.fiuba.algo3.modelo.Raza.Reserva.Reserva;

import java.util.ArrayList;

public class Raza {
    private Reserva reservaMineral;
    private Reserva reservaGas;
    private ArrayList<Estructura> estructuras;
    private ArrayList<Criadero> criaderos;
    private ArrayList<Unidad> unidades;

    public Raza() {
        this.reservaMineral = new Reserva();
        this.reservaGas = new Reserva();
        this.estructuras = new ArrayList<>();
        this.criaderos = new ArrayList<>();
        this.unidades = new ArrayList<>();
    }

    public void recolectarGas(int unidades) {
        reservaGas.agregarRecurso(unidades);
    }

    public void recolectarMineral(int unidades) {
        reservaMineral.agregarRecurso(unidades);
    }

    public int suministroRestante() {
        int suministroTotal = 0;
        for (Estructura estructura : estructuras) {
            estructura.afectarSuministro(suministroTotal);
        }
        for (Unidad unidad : unidades) {
            unidad.afectarSuministro(suministroTotal);
        }
        return suministroTotal;
    }

    public void gastarRecursos(int mineral, int gas) {
        reservaGas.gastarRecurso(gas);
        reservaMineral.gastarRecurso(mineral);
    }


    public void registarEntidad(Estructura entidad) {
        estructuras.add(entidad);
    }

    public void registarEntidad(Criadero criadero) {
        criaderos.add(criadero);
    }

    public void registarEntidad(Unidad entidad) {
        unidades.add(entidad);
    }

    public void destruirEntidad(Entidad entidad) {
        estructuras.remove(entidad);
        unidades.remove(entidad);
    }

    public boolean sinEstructuras() {
        return estructuras.isEmpty();
    }

    //Solo aplica a la raza Zerg, deberian ser dos razas distintas.
    //Se con certeza si es un Extractor porque es la unica que se puede construir
    //sobre un volcan de Gas. Se con certeza que el area tiene uno.
    public Extractor buscarExtractor(Area area) {
        Estructura extractor = null;
        int i = 0;
        while (extractor == null && i < estructuras.size()) {
            extractor = estructuras.get(i).estaConstruidaEnArea(area);
            i++;
        }
        return (Extractor) extractor;
    }

    public void usarLarva() {
        boolean larvaUsada = false;
        int i = 0;
        while (!larvaUsada && i < criaderos.size()) {
            try {
                criaderos.get(i).usarLarva();
                larvaUsada = true;
            } catch (CriaderoSinLarvasException e) {
                i++;
            }
        }
        if (!larvaUsada) {
            throw new RazaZergSinLarvasException();
        }
    }
}
