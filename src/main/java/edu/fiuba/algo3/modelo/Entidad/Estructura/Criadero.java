package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.GenerarLarva;
import edu.fiuba.algo3.modelo.Entidad.GeneraLarva;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Criadero extends Estructura implements GeneraLarva {
    private int larvas;

    public Criadero(Posicion posicion) {
        super(posicion);
        this.estadoEstructura = new EnConstruccion(4);
        this.larvas = 3;
        this.vida = new Regenerativa(500);
        this.defensa = new SinEscudo();
        this.accionAlPasarTurno = new GenerarLarva(this);
    }

    //Este metodo es propio y unico de esta estructura. Capaz puede estar atado a la interfaz.
    public void usarLarva() {
        this.estadoEstructura.operable();
        if (this.larvas == 0) {
            throw new CriaderoSinLarvasException();
        }
        this.larvas -= 1;
    }

    @Override
    public void generarLarva() {
        if (this.larvas < 3) {
            this.larvas += 1;
        }
    }

    //Idem a arriba.
    public Piso generarMoho() {
        return new Moho(this.posicion);
    }


    @Override
    public void construible(Construible requiereOtraEstructura) {
        requiereOtraEstructura.manejar(Criadero.class);
    }
}