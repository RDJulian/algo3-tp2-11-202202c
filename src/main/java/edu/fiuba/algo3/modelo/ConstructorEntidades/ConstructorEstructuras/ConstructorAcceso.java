package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.NoRequiereEstructura;
import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.RangoPilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class ConstructorAcceso implements ConstructorEstructuras {
    @Override
    public Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Raza raza, Estructura estructuraCorrelativa) {
        posicion.ocupable();
        recurso.construible(new NoSobreRecurso());
        piso.construible(new RangoPilon(), posicion);
        raza.construible(150, 0);
        ConstruibleEstructura requiereEstructura = new NoRequiereEstructura();
        requiereEstructura.visitar(estructuraCorrelativa);

        raza.gastarRecursos(150, 0);
        return new Acceso(posicion);
    }
}