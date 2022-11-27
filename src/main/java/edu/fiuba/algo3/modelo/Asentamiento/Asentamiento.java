package edu.fiuba.algo3.modelo.Asentamiento;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Excepciones.SuministroInsuficienteException;

import java.util.ArrayList;

public class Asentamiento {

    private ArrayList<Entidad> entidades;

    public Asentamiento() {
        this.entidades = new ArrayList<>();
    }

    public int suministroRestante() {
        int suministroActual = 0;
        for (Entidad entidad : entidades) {
            suministroActual = entidad.afectarSuministro(suministroActual);
        }
        return suministroActual;
    }

    public void construible(int costoSuministro) {
        if (suministroRestante() < costoSuministro) {
            throw new SuministroInsuficienteException();
        }
    }

    public void registrarEntidad(Entidad entidad) {
        entidades.add(entidad);
    }
}
