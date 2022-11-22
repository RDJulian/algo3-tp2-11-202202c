package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.RequiereReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorZerling implements ConstructorUnidades{
    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa){
        estructuraCorrelativa.construible(new RequiereReservaDeReproduccion());
        raza.construible(25, 0);

        raza.gastarRecursos(25,0);
        return new Zangano(posicion);
    }
}
