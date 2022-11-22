package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Construible.NoRequiereEstructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class ConstructorAmoSupremo implements ConstructorUnidades{
    //Suponemos que el AmoSupremo se construye sin ninguna Estructura, pero deberia igual requerir un criadero
    //para tener larvas.
    public Unidad construir(Posicion posicion, Raza raza, Estructura estructuraCorrelativa){
        estructuraCorrelativa.construible(new NoRequiereEstructura());
        raza.construible(50, 0);

        raza.gastarRecursos(50,0);
        return new Zangano(posicion);
    }
}
