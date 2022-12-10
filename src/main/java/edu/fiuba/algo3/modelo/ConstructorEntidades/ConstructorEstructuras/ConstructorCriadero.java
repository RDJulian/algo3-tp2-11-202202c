package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Raza.Raza;

import java.util.ArrayList;

public class ConstructorCriadero extends ConstructorEstructuras {
    private ArrayList<Piso> pisos;

    public ConstructorCriadero(ArrayList<Estructura> estructuras, Raza raza, ArrayList<Piso> pisos) {
        super(estructuras, raza);
        this.pisos = pisos;
    }

    public ConstructorCriadero(ArrayList<Estructura> estructuras, Raza raza) {
        super(estructuras, raza);
        this.pisos = new ArrayList<>();
    }

    @Override
    public Estructura construir(Area area) {
        Criadero criadero = new Criadero(area, raza);
        pisos.add(criadero.generarMoho());
        return criadero;
    }
}