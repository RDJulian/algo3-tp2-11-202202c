package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLleno;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.Vector;

public class Extractor extends Estructura implements ExtraeRecurso {
    private Vector<Zangano> zanganos;
    private Recurso gasVespeno;
    private Reserva reserva;

    public Extractor() {
        this.estadoOperativo = new EnConstruccion(6);
        this.estadoEnergetico = new Activo();
        this.construible = new Construible(new SobreGasVespeno(), new NoSobreMoho(), new Costo(100, 0));
        this.zanganos = new Vector<>(0);
        this.vida = new Regenerativa(750);
        this.defensa = new SinEscudo();
    }

    @Override
    public void efectuarOperacion() {

    }

    @Override
    public void pasarTurnoOperativo() {
        for (Zangano zangano : zanganos) {
            zangano.extraerRecurso(this.gasVespeno, this.reserva);
        }
    }

    @Override
    public void construir(Recurso recurso) {
        recurso.ocupable();
        this.gasVespeno = recurso;
    }

    public void agregarZangano(Zangano zangano) {
        if (zanganos.size() >= 3) {
            throw new ExtractorLleno();
        }
        this.zanganos.add(zangano);
    }

    //Creo este metodo para setear la reserva por ahora
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}