package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Criadero extends Estructura {
    private int larvas;

    public Criadero(Posicion posicion) {
        super(posicion);
        this.estadoEstructura = new EnConstruccion(4);
        this.larvas = 3;
        this.vida = new Regenerativa(500);
        this.defensa = new SinEscudo();
    }

    public void usarLarva() {
        this.estadoEstructura.operable();
        if (this.larvas == 0) {
            throw new CriaderoSinLarvasException();
        }
        this.larvas -= 1;
    }

    @Override
    public void pasarTurnoOperativo() {
        if (this.larvas < 3) {
            this.larvas += 1;
        }
    }

    public Piso generarMoho() {
        return new Moho(this.posicion);
    }


    @Override
    public void construible(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.manejar(Criadero.class);
    }
}