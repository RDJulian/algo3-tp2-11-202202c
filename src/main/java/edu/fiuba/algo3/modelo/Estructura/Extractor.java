package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLlenoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.Vector;

public class Extractor extends Estructura implements ExtraeRecurso {
    private Vector<Zangano> zanganos;
    private Recurso gasVespeno;
    private Reserva reservaGas;

    public Extractor(Posicion posicion, Recurso gasVespeno, Reserva reservaGas) {
        super(posicion);
        this.gasVespeno = gasVespeno;
        gasVespeno.ocupar(this);
        this.reservaGas = reservaGas;
        this.estadoEstructura = new EnConstruccion(6);
        this.zanganos = new Vector<>(0);
        this.vida = new Regenerativa(750);
        this.defensa = new SinEscudo();
    }

    @Override
    public void pasarTurnoOperativo() {
        for (Zangano zangano : zanganos) {
            zangano.usarExtractor(this.gasVespeno, this.reservaGas, this);
        }
    }


    public void agregarZangano(Zangano zangano) {
        if (zanganos.size() >= 3) {
            throw new ExtractorLlenoException();
        }
        this.zanganos.add(zangano);
    }

    //Creo este metodo para setear la reserva por ahora
    public void setReserva(Reserva reserva) {
        this.reservaGas = reserva;
    }

    @Override
    public void construible(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.manejar(Extractor.class);
    }
}