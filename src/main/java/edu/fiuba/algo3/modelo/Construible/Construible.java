package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Construible { //Esta clase parece ser anemica. Todas las excepciones deberian estar manejadas aca.
    ConstruibleSobreRecurso sobreRecurso;
    ConstruibleSobreRango sobreRango;
    Costo costo;
    RequiereOtraEstructura requiereOtraEstructura;

    public Construible(ConstruibleSobreRecurso sobreRecurso, ConstruibleSobreRango sobreRango, Costo costo, RequiereOtraEstructura requiereOtraEstructura) {
        this.sobreRecurso = sobreRecurso;
        this.sobreRango = sobreRango;
        this.costo = costo;
        this.requiereOtraEstructura = requiereOtraEstructura;
    }

    public void construible(Recurso recurso) {
        this.sobreRecurso.construible(recurso);
    }

    public void construible(Piso piso, Posicion posicion) {
        this.sobreRango.construible(piso, posicion);
    }

    public void construible(Reserva reservaMineral, Reserva reservaGas) {
        this.costo.construible(reservaMineral, reservaGas);
    }

    public void construible(Estructura estructura) {
        this.requiereOtraEstructura.construible(estructura);
    }
}