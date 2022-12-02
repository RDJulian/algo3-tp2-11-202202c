package edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
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

        this.estadoEntidad = new EnConstruccion(4);
        this.rolEnSuministro = new Proveedor();
        this.vida = new Regenerativa(500);
        this.defensa = new SinEscudo();
        this.raza = raza;
        this.larvas = new Larvas();
    }

    //Este metodo es propio y unico de esta estructura.
    public void usarLarva() {
        estadoEntidad.operable();
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
        estadoEntidad.operable();
    }

    @Override
    public void pasarTurno() {
        try {
            estadoEntidad.operable();
            generarLarva();
            estadoEntidad = estadoEntidad.pasarTurno(vida, defensa);
        } catch (EntidadNoOperativaException exception) {
            estadoEntidad = estadoEntidad.pasarTurno(vida, defensa);
        }
    }
}