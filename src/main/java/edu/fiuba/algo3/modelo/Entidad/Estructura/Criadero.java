package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.GenerarLarva;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.RolEnSuministro.Proveedor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Criadero extends Estructura implements GeneraLarva {
    private int larvas;

    public Criadero(Posicion posicion) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoEntidad = new EnConstruccion(4);
        this.accionAlPasarTurno = new GenerarLarva(this);
        this.vida = new Regenerativa(500);
        this.defensa = new SinEscudo();

        this.larvas = 3;

        this.rolEnSuministro = new Proveedor();
    }

    //Este metodo es propio y unico de esta estructura.
    public void usarLarva() {
        estadoEntidad.operable();
        if (larvas == 0) {
            throw new CriaderoSinLarvasException();
        }
        larvas -= 1;
    }

    @Override
    public void generarLarva() {
        if (larvas < 3) {
            larvas += 1;
        }
    }

    //Idem a arriba.
    public Piso generarMoho() {
        return new Moho(posicion);
    }


    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}