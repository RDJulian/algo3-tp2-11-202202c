package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.RevelaEntidades;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Raza.Reserva.Reserva;

import java.util.ArrayList;

public abstract class Raza {
    protected Reserva reservaMineral;
    protected Reserva reservaGas;

    protected ArrayList<Unidad> unidades;

    protected ArrayList<Estructura> estructuras;
    protected ArrayList<RevelaEntidades> reveladores;

    public Raza() {
        this.reservaMineral = new Reserva();
        this.reservaGas = new Reserva();
        this.unidades = new ArrayList<>();
        this.estructuras = new ArrayList<>();
        this.reveladores = new ArrayList<>();
    }

    public Raza(int mineral, int gas) {
        this();
        recolectarMineral(mineral);
        recolectarGas(gas);
    }

    public void recolectarGas(int unidades) {
        reservaGas.agregarRecurso(unidades);
    }

    public void recolectarMineral(int unidades) {
        reservaMineral.agregarRecurso(unidades);
    }

    public void gastarRecursos(int mineral, int gas) {
        reservaGas.gastarRecurso(gas);
        reservaMineral.gastarRecurso(mineral);
    }

    public void registrarEntidad(Unidad unidad) {
        unidades.add(unidad);
    }

    public void registrarEntidad(Estructura estructura) {
        estructuras.add(estructura);
    }

    public int suministroRestante() {
        int suministroTotal = 0;
        for (Estructura estructura : estructuras) {
            suministroTotal = estructura.afectarSuministro(suministroTotal);
        }
        for (Unidad unidad : unidades) {
            suministroTotal = unidad.afectarSuministro(suministroTotal);
        }
        return suministroTotal;
    }

    public void destruirEntidad(Entidad entidad) {
        estructuras.remove(entidad);
        unidades.remove(entidad);
        reveladores.remove(entidad);
    }

    public void pasarTurno() {
        for (Estructura estructura : estructuras) {
            estructura.pasarTurno();
        }
        for (Unidad unidad : unidades) {
            unidad.pasarTurno();
        }
    }

    public boolean sinEstructuras() {
        return estructuras.isEmpty();
    }

    //Metodo para testear.
    public ArrayList<Estructura> getEstructuras() {
        return estructuras;
    }
}
