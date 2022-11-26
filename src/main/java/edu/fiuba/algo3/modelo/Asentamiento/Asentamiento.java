package edu.fiuba.algo3.modelo.Asentamiento;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.SuministroInsuficienteException;

import java.util.ArrayList;

public class Asentamiento {

    private ArrayList<Estructura> estructruras;
    private ArrayList<Unidad> unidades;

    public Asentamiento(){
        this.estructruras = new ArrayList();
        this.unidades = new ArrayList();
    }

    public int suministroRestante(){
        int suministroActual = 0;
        for (Estructura estructura: estructruras) {
            suministroActual = estructura.afectarSuministro(suministroActual);
        }
        for (Unidad unidad: unidades) {
            suministroActual = unidad.afectarSuministro(suministroActual);
        }

        return suministroActual;
    }

    public void construible(int costoSuministro) {
        int suministroActual = this.suministroRestante() - costoSuministro;
        if (suministroActual<0){
            throw new SuministroInsuficienteException();
        }
    }

    public void registrarEstructura(Estructura construccion) {
        estructruras.add(construccion);
    }

    public void registrarUnidad(Unidad unidad) {
        unidades.add(unidad);
    }
}
