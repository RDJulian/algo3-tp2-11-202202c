package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.Costo;
import edu.fiuba.algo3.modelo.Construible.NoNecesitaRango;
import edu.fiuba.algo3.modelo.Construible.SobreGasVespeno;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLleno;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Trabajador.Zangano;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.Vector;

public class Extractor extends Estructura {
    private Vector<Zangano> zanganos;
    private Recurso gasVespeno;
    private Reserva reserva;

    public Extractor(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(6);
        this.construible = new Construible(new SobreGasVespeno(), new NoNecesitaRango(), new Costo(100, 0));
        this.zanganos = new Vector<Zangano>(0);
        this.vida = new Regenerativa(750);
        this.defensa = new SinEscudo();
    }

    public Extractor(Posicion posicion, Reserva reserva) {
        super(posicion);
        this.estado = new EnConstruccion(6);
        this.construible = new Construible(new SobreGasVespeno(), new NoNecesitaRango(), new Costo(100, 0));
        this.reserva = reserva;
        this.zanganos = new Vector<Zangano>(0);
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
        this.vida.regenerar();
        this.defensa.regenerar();
    }

    @Override
    public void construir(Recurso recurso) {
        this.gasVespeno = recurso;
    }

    public void agregarZangano(Zangano zangano) {
        if (zanganos.size() >= 3) {
            throw new ExtractorLleno();
        }
        this.zanganos.add(zangano);
    }
}