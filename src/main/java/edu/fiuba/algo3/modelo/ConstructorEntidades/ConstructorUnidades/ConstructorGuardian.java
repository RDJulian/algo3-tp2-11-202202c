package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class ConstructorGuardian extends ConstructorUnidades {
    static private ConstructorUnidades instancia;

    public ConstructorGuardian(ArrayList<Estructura> estructuras, Raza raza) {
        super(estructuras, raza);
        instancia = this;
    }

    public static ConstructorUnidades obtenerInstancia() {
        return instancia;
    }

    public Unidad construir(Area area) {
        return new Guardian(area, raza);
    }
}
