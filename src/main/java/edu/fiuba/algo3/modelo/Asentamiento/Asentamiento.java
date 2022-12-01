package edu.fiuba.algo3.modelo.Asentamiento;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.SuministroInsuficienteException;

import java.util.ArrayList;

public class Asentamiento {
    private ArrayList<Entidad> entidades;

    public Asentamiento() {
        this.entidades = new ArrayList<>();
    }

    public int suministroRestante(int suministro) {
        for (Entidad entidad : entidades) {
            suministro = entidad.afectarSuministro(suministro);
        }
        return suministro;
    }

    public void registrarEntidad(Entidad entidad) {
        entidades.add(entidad);
    }

    public void destruirEntidad(Entidad entidad) {
        entidades.remove(entidad);
    }

    public boolean sinEntidades() {
        return entidades.isEmpty();
    }
}
