package edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.GeneraLarva;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Proveedor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Criadero extends Estructura implements GeneraLarva {
    private Larvas larvas;

    public Criadero(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Visible();
        this.rolEnSuministro = new Proveedor();
        this.vida = new Regenerativa(500);
        this.defensa = new SinEscudo();
        this.raza = raza;
        this.larvas = new Larvas();
    }

    public void usarLarva() {
        estadoOperativo.operable();
        larvas.usarLarva();
    }

    @Override
    public void generarLarva() {
        larvas.generarLarva();
    }

    //Idem a arriba.
    public Piso generarMoho() {
        return new Moho(posicion);
    }


    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        estadoOperativo.operable();
    }

    @Override
    public void pasarTurno() {
        try {
            estadoOperativo.operable();
            generarLarva();
            estadoOperativo = estadoOperativo.pasarTurno(vida, defensa);
        } catch (EntidadNoOperativaException exception) {
            estadoOperativo = estadoOperativo.pasarTurno(vida, defensa);
        }
    }
}