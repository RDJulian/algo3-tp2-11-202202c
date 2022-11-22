package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.RequiereAcceso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorDragon implements ConstructorUnidades{
    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa){
        estructuraCorrelativa.construible(new RequiereAcceso());
        raza.construible(125, 50);

        raza.gastarRecursos(125, 50);
        return new Zangano(posicion);
    }
}
