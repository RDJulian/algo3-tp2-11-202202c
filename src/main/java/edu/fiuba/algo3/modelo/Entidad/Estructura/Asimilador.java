package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.ExtraerRecurso;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Entidad.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Asimilador extends Estructura implements ExtraeRecurso {
    private Recurso gasVespeno;
    private Raza raza;

    public Asimilador(Posicion posicion, Recurso gasVespeno, Raza raza) {
        super(posicion);
        this.gasVespeno = gasVespeno;
        gasVespeno.ocupar(this);
        this.raza = raza;
        this.estadoEstructura = new EnConstruccion(6);
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);
        this.accionAlPasarTurno = new ExtraerRecurso(this);
    }

    @Override
    public void extraerRecurso() {
        gasVespeno.extraerRecurso(20, this.raza, this);
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}