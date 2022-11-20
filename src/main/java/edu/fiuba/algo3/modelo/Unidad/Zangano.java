package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Recurso.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zangano extends Unidad implements ExtraeRecurso {
    Recurso mineral;
    Reserva reservaMineral;

    public Zangano() {
        this.danioAire = 0;
        this.danioTierra = 0;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Regenerativa(25);
        this.defensa = new SinEscudo();
        this.estadoEstructura = new EnConstruccion(1);
    }

    public void usarExtractor(Recurso recurso, Reserva reserva, ExtraeRecurso extractor) {
        recurso.extraerRecurso(10, reserva, extractor);
    }

    public void extraerRecurso() {
        this.mineral.extraerRecurso(10, this.reservaMineral, this);
    }

    public void ocupar(Recurso mineral) {
        mineral.ocupar(this);
        this.mineral = mineral;
    }

    //Dejo este setter por el momento para no cambiar tanto los casos de uso,
    //capaz como el Zangano es la unica unidad que extrae algun recurso, podria
    //pedir desde el constructor una reservaMineral, como las estructuras.
    public void setReserva(Reserva reservaMineral) {
        this.reservaMineral = reservaMineral;
    }
}
