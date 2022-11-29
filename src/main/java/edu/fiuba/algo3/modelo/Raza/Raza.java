package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Asentamiento.Asentamiento;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Raza {

    //Esta clase deberia tener mas responsabilidad. Deberia ser como clase manejadora de
    //lo que corresponda a una Raza (estructuras, unidades, etc.)
    //La desventaja de tener una clase como esta es que se termina haciendo pasamano con las reservas.
    private Reserva reservaMineral;
    private Reserva reservaGas;
    private Asentamiento asentamiento;

    public Raza() {
        this.reservaMineral = new Reserva();
        this.reservaGas = new Reserva();
        this.asentamiento = new Asentamiento();
    }

    //Estos metodos delegan a las Reservas correspondientes.
    //Sirven tanto para unidades como para estructuras.
    //Como las reservas son de la misma clase, se necesita dos metodos separados para cada una.
    public void recolectarGas(int unidades) {
        reservaGas.agregarRecurso(unidades);
    }

    public void recolectarMineral(int unidades) {
        reservaMineral.agregarRecurso(unidades);
    }

    public void construible(int costoMineral, int costoGas, int costoSuministro) {
        this.reservaMineral.construible(costoMineral);
        this.reservaGas.construible(costoGas);
        this.asentamiento.construible(costoSuministro);
    }

    public void gastarRecursos(int mineral, int gas) {
        reservaGas.gastarRecurso(gas);
        reservaMineral.gastarRecurso(mineral);
    }

    //Ver si es necesario. Metodo para testear.
    public int suministroRestante() {
        return this.asentamiento.suministroRestante();
    }

    public void registarEntidad(Estructura entidad) {
        asentamiento.registrarEntidad(entidad);
    }

    public void registarEntidad(Unidad entidad) {
        asentamiento.registrarEntidad(entidad);
    }

    public void destruirEntidad(Estructura entidad) {
        asentamiento.destruirEntidad(entidad);
    }

    public void destruirEntidad(Unidad entidad) {
        asentamiento.destruirEntidad(entidad);
    }


    public boolean sinEstructuras() {
        return asentamiento.sinEstructuras();
    }
}
