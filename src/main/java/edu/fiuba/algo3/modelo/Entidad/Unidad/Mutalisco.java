package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Mutalisco extends Unidad {
    public Mutalisco() {
        this.danioAire = 9;
        this.danioTierra = 9;
        this.tipoUnidad = new UnidadAire();
        this.vida = new Regenerativa(120);
        this.defensa = new SinEscudo();
        this.estadoEntidad = new EnConstruccion(7);
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
