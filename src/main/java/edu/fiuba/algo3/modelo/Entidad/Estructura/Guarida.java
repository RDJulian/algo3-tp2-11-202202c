package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Guarida extends Estructura {
    public Guarida(Posicion posicion) {
        super(posicion);
        this.estadoEstructura = new EnConstruccion(12);
        this.vida = new Regenerativa(1250);
        this.defensa = new SinEscudo();
        this.accionAlPasarTurno = new Nada();
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}
