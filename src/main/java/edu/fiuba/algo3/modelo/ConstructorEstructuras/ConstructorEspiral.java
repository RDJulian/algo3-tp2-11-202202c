package edu.fiuba.algo3.modelo.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.RequiereGuarida;
import edu.fiuba.algo3.modelo.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class ConstructorEspiral implements ConstructorEstructuras {
    @Override
    public Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Reserva reservaMineral, Reserva reservaGas, Estructura estructuraCorrelativa) {
        posicion.ocupable();
        recurso.construible(new NoSobreRecurso());
        piso.construible(new RangoMoho(), posicion);
        reservaMineral.construible(150);
        reservaGas.construible(100);
        estructuraCorrelativa.construible(new RequiereGuarida());

        return new Espiral(posicion);
    }
}