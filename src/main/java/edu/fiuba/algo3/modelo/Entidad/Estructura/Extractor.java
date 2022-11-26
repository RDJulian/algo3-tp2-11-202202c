package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.ExtraerRecurso;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLlenoException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

import java.util.Vector;

public class Extractor extends Estructura implements ExtraeRecurso {
    private Vector<Zangano> zanganos;
    private Recurso gasVespeno;
    private Raza raza;

    public Extractor(Posicion posicion, Recurso gasVespeno, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();
        this.gasVespeno = gasVespeno;
        gasVespeno.ocupar(this);
        this.raza = raza;

        this.estadoEntidad = new EnConstruccion(6);
        this.accionAlPasarTurno = new ExtraerRecurso(this);
        this.vida = new Regenerativa(750);
        this.defensa = new SinEscudo();

        this.zanganos = new Vector<>(0);
        this.rolEnSuministro = new Neutral();
    }

    @Override
    public void extraerRecurso() {
        for (Zangano zangano : zanganos) {
            zangano.usarExtractor(gasVespeno, raza, this);
        }
    }

    //Este metodo es propio y unico de esta estructura.
    public void agregarZangano(Zangano zangano) {
        if (zanganos.size() >= 3) {
            throw new ExtractorLlenoException();
        }
        zanganos.add(zangano);
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}