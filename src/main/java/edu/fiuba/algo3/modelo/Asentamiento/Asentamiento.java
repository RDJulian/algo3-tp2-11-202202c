package edu.fiuba.algo3.modelo.Asentamiento;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.SuministroInsuficienteException;

import java.util.ArrayList;

public class Asentamiento {

    private ArrayList<Entidad> estructuras;
    private ArrayList<Entidad> unidades;

    public Asentamiento() {
        this.estructuras = new ArrayList<>();
        this.unidades = new ArrayList<>();
    }

    public int suministroRestante() {
        int suministroActual = 0;
        for (Entidad entidad : estructuras) {
            suministroActual = entidad.afectarSuministro(suministroActual);
        }
        for (Entidad entidad : unidades) {
            suministroActual = entidad.afectarSuministro(suministroActual);
        }
        return suministroActual;
    }

    public void construible(int costoSuministro) {
        if (suministroRestante() < costoSuministro) {
            throw new SuministroInsuficienteException();
        }
    }

    public void registrarEntidad(Estructura entidad) {
        estructuras.add(entidad);
    }

    public void registrarEntidad(Unidad entidad) {
        unidades.add(entidad);
    }

    public void destruirEntidad(Estructura entidad) {
        estructuras.remove(entidad);
    }

    public void destruirEntidad(Unidad entidad) {
        unidades.remove(entidad);
    }
    
    public boolean sinEstructuras() {
        return estructuras.isEmpty();
    }
}
