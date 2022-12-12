package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Devorador;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Excepciones.ConstructorNoInicializadoException;
import edu.fiuba.algo3.modelo.Excepciones.ConstructorYaInicializadoException;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class ConstructorDevorador extends ConstructorUnidades {
    //Singleton pattern.
    static private ConstructorDevorador instancia;

    private ConstructorDevorador(ArrayList<Estructura> estructuras, Raza raza) {
        super(estructuras, raza);
        instancia = this;
    }

    public ConstructorDevorador inicializar(ArrayList<Estructura> estructuras, Raza raza) {
        if (instancia != null) {
            throw new ConstructorYaInicializadoException();
        }
        return new ConstructorDevorador(estructuras, raza);
    }

    public static ConstructorDevorador obtenerInstancia() {
        if (instancia == null) {
            throw new ConstructorNoInicializadoException();
        }
        return instancia;
    }

    public Unidad construir(Area area) {
        return new Devorador(area, raza);
    }
}
