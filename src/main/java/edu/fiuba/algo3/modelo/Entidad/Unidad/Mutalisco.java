package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Mutalisco extends Unidad {
    public Mutalisco(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(7);
        this.accionAlPasarTurno = new Nada();
        this.rolEnSuministro = new Consumidor(4);
        this.vida = new Regenerativa(120);
        this.defensa = new SinEscudo();
        this.raza = raza;

        this.tipoUnidad = new UnidadAire();
        this.danioTierra = 9;
        this.danioAire = 9;
        this.rangoAtaque = 3;
        this.invisible = false;
        this.contadorDeBajas = 0;
    }

    public void evolucionarAGuardian(Reserva reservaMineral, Reserva reservaGas) {
        reservaMineral.construible(50);
        reservaGas.construible(100);
    }

    public void evolucionarADevorador(Reserva reservaMineral, Reserva reservaGas) {
        reservaMineral.construible(150);
        reservaGas.construible(50);
    }
}
