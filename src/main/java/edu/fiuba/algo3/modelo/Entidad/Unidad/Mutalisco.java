package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataca;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadAire;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Entidad.Suministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Mutalisco extends Unidad {
    public Mutalisco(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoOperativo = new EnConstruccion(7);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new Consumidor(4);
        this.vida = new Regenerativa(120);
        this.defensa = new SinEscudo();
        this.raza = raza;

        this.tipoUnidad = new UnidadAire();
        this.ataque = new Ataca(this, 9, 9, 3);
        this.contadorDeBajas = 0;
    }

    public void evolucionarAGuardian(Reserva reservaMineral, Reserva reservaGas) {
        reservaMineral.construible(50);
        reservaGas.construible(100);

        reservaMineral.gastarRecurso(50);
        reservaGas.gastarRecurso(100);

        raza.registarEntidad(new Guardian(posicion, raza));
        destruir();
    }

    public void evolucionarADevorador(Reserva reservaMineral, Reserva reservaGas) {
        reservaMineral.construible(150);
        reservaGas.construible(50);

        reservaMineral.gastarRecurso(150);
        reservaGas.gastarRecurso(50);

        raza.registarEntidad(new Devorador(posicion, raza));
        destruir();
    }
}
