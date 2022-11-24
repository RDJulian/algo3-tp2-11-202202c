package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Guarida;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class ConstructorGuarida implements ConstructorEstructuras {
    @Override
    public Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Raza raza, Estructura estructuraCorrelativa) {
        posicion.ocupable();
        recurso.construible(new NoSobreRecurso());
        piso.construible(new RangoMoho(), posicion);
        raza.construible(200, 100);
        ConstruibleEstructura requiereEstructura = new RequiereReservaDeReproduccion();
        requiereEstructura.visitar(estructuraCorrelativa);

        raza.gastarRecursos(200, 100);
        return new Guarida(posicion);
    }
}