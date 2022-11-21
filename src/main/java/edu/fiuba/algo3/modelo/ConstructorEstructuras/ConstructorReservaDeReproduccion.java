package edu.fiuba.algo3.modelo.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.NoRequiereEstructura;
import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.RangoMoho;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class ConstructorReservaDeReproduccion implements ConstructorEstructuras {
    @Override
    public Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Raza raza, Estructura estructuraCorrelativa) {
        posicion.ocupable();
        recurso.construible(new NoSobreRecurso());
        piso.construible(new RangoMoho(), posicion);
        raza.construible(150, 0);
        estructuraCorrelativa.construible(new NoRequiereEstructura());

        raza.gastarRecursos(150, 0);
        return new ReservaDeReproduccion(posicion);
    }
}