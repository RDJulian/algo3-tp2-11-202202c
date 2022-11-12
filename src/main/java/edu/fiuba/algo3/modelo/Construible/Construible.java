package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Construible {
    ConstruibleSobreRecurso sobreRecurso;
    ConstruibleSobreRango sobreRango;
    Costo costo;

    public Construible(ConstruibleSobreRecurso sobreRecurso, ConstruibleSobreRango sobreRango, Costo costo) {
        this.sobreRecurso = sobreRecurso;
        this.sobreRango = sobreRango;
        this.costo = costo;
    }

    public void construible(Recurso recurso) {
        this.sobreRecurso.construible(recurso);
    }

    public void construible(Pilon pilon, Posicion posicion) {
        this.sobreRango.construible(pilon, posicion);
    }

    public void construible(Piso moho, Posicion posicion) {
        this.sobreRango.construible(moho, posicion);
    }

    public void construible(Reserva reservaMineral, Reserva reservaGas) {
        this.costo.construible(reservaMineral, reservaGas);
    }
}