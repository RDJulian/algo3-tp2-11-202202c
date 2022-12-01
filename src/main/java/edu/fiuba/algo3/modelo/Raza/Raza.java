package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Asentamiento.Asentamiento;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.SuministroInsuficienteException;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Raza {
    private Reserva reservaMineral;
    private Reserva reservaGas;
    private Asentamiento asentamientoEstructuras;
    private Asentamiento asentamientoUnidades;

    public Raza() {
        this.reservaMineral = new Reserva();
        this.reservaGas = new Reserva();
        this.asentamientoEstructuras = new Asentamiento();
        this.asentamientoUnidades = new Asentamiento();
    }

    public void recolectarGas(int unidades) {
        reservaGas.agregarRecurso(unidades);
    }

    public void recolectarMineral(int unidades) {
        reservaMineral.agregarRecurso(unidades);
    }

    public void construible(int costoMineral, int costoGas, int costoSuministro) {
        this.reservaMineral.construible(costoMineral);
        this.reservaGas.construible(costoGas);
        if (suministroRestante() < costoSuministro) {
            throw new SuministroInsuficienteException();
        }
    }

    public int suministroRestante() {
        int suministroTotal = 0;
        suministroTotal = asentamientoEstructuras.suministroRestante(suministroTotal);
        suministroTotal = asentamientoUnidades.suministroRestante(suministroTotal);
        return suministroTotal;
    }

    public void gastarRecursos(int mineral, int gas) {
        reservaGas.gastarRecurso(gas);
        reservaMineral.gastarRecurso(mineral);
    }


    public void registarEntidad(Estructura entidad) {
        asentamientoEstructuras.registrarEntidad(entidad);
    }

    public void registarEntidad(Unidad entidad) {
        asentamientoUnidades.registrarEntidad(entidad);
    }

    public void destruirEntidad(Entidad entidad) {
        asentamientoEstructuras.destruirEntidad(entidad);
        asentamientoUnidades.destruirEntidad(entidad);
    }

    public boolean sinEstructuras() {
        return asentamientoEstructuras.sinEntidades();
    }


}
