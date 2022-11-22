package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.RequiereEspiral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorMutalisco implements ConstructorUnidades{
    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa){
        estructuraCorrelativa.construible(new RequiereEspiral());
        raza.construible(100, 100);

        raza.gastarRecursos(100,100);
        return new Zangano(posicion);
    }
}
