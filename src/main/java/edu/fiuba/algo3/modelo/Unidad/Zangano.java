package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Recurso.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zangano extends Unidad implements ExtraeRecurso {

    public Zangano() {
        this.danioAire = 0;
        this.danioTierra = 0;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Regenerativa(25);
        this.defensa = new SinEscudo();
        this.estadoOperativo = new EnConstruccion(1);
    }

    public void usarExtractor(Recurso recurso, Reserva reserva, ExtraeRecurso extractor) {
        recurso.extraerRecurso(10, reserva, extractor);
    }

    public void extraerRecurso(Recurso recurso, Reserva reserva) {
        recurso.extraerRecurso(10, reserva, this);
    }

    public void ocupar(Recurso mineral) { // No parece una buena solucion
        mineral.ocupable(this);
    }

    @Override
    public void setReserva(Reserva reserva) { // Puede servir

    }
}
