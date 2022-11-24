package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.ExtraerRecurso;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLlenoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.Vector;

public class Extractor extends Estructura implements ExtraeRecurso {
    private Vector<Zangano> zanganos;
    private Recurso gasVespeno;
    private Raza raza;

    public Extractor(Posicion posicion, Recurso gasVespeno, Raza raza) {
        super(posicion);
        this.gasVespeno = gasVespeno;
        gasVespeno.ocupar(this);
        this.raza = raza;
        this.estadoEstructura = new EnConstruccion(6);
        this.zanganos = new Vector<>(0);
        this.vida = new Regenerativa(750);
        this.defensa = new SinEscudo();
        this.accionAlPasarTurno = new ExtraerRecurso(this);
    }

    @Override
    public void extraerRecurso() {
        for (Zangano zangano : zanganos) {
            zangano.usarExtractor(this.gasVespeno, this.raza, this);
        }
    }

    //Este metodo es propio y unico de esta estructura, pero no tendria sentido juntarlo a ninguna interfaz
    //por ahora.
    public void agregarZangano(Zangano zangano) {
        if (zanganos.size() >= 3) {
            throw new ExtractorLlenoException();
        }
        this.zanganos.add(zangano);
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}