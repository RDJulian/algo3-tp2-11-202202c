package edu.fiuba.algo3.modelo.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class ConstructorAsimilador implements ConstructorEstructuras {
    @Override
    public Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Reserva reservaMineral, Reserva reservaGas, Estructura estructuraCorrelativa) {
        posicion.ocupable();
        recurso.construible(new SobreGasVespeno());
        piso.construible(new RangoPilon(), posicion);
        reservaMineral.construible(100);
        reservaGas.construible(0);
        estructuraCorrelativa.construible(new NoRequiereOtra());

        return new Asimilador(posicion, recurso, reservaGas);
    }
}