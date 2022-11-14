package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvas;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Criadero extends Estructura {
    private int larvas;

    public Criadero() {
        this.estadoOperativo = new EnConstruccion(4);
        this.estadoEnergetico = new Activo();
        this.construible = new Construible(new NoSobreRecurso(), new RangoMoho(), new Costo(50, 0), new NoRequiereOtra());
        this.larvas = 3;
        this.vida = new Regenerativa(500);
        this.defensa = new SinEscudo();
    }

    @Override
    public Piso construiblePiso(Piso piso) {
        this.construible.construible(piso, this.posicion);
        return new Moho(this.posicion);
    }

    @Override
    public void efectuarOperacion() {
        if (this.larvas == 0) {
            throw new CriaderoSinLarvas();
        }
        this.larvas -= 1;
    }

    @Override
    public void pasarTurnoOperativo() {
        if (this.larvas < 3) {
            this.larvas += 1;
        }
    }

    @Override
    public void construir(Recurso recurso) {

    }

    @Override
    public void construirConOtraEstructura(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.construibleConCriadero();
    }
}