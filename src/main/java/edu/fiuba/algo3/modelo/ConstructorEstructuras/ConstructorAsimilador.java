package edu.fiuba.algo3.modelo.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class ConstructorAsimilador implements ConstructorEstructuras {
    @Override
    public Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Raza raza, Estructura estructuraCorrelativa) {
        posicion.ocupable();
        recurso.construible(new SobreGasVespeno());
        piso.construible(new RangoPilon(), posicion);
        raza.construible(100, 0);
        estructuraCorrelativa.construible(new NoRequiereEstructura());

        raza.gastarRecursos(100, 0);
        return new Asimilador(posicion, recurso, raza);
    }
}