package edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura;

import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;

import java.util.ArrayList;

public abstract class ConstruibleEstructura {
    public boolean construible(ArrayList<Estructura> estructuras) {
        boolean construible = false;
        int i = 0;
        while (!construible && i < estructuras.size()) {
            construible = estructuras.get(i).construible(this);
            i++;
        }
        return construible;
    }

    public abstract boolean visitar(Acceso acceso);

    public abstract boolean visitar(Espiral espiral);

    public abstract boolean visitar(Guarida guarida);

    public abstract boolean visitar(PuertoEstelar puertoEstelar);

    public abstract boolean visitar(ReservaDeReproduccion reservaDeReproduccion);

    public abstract boolean visitar(Criadero criadero);

    public abstract boolean visitar(EstructuraNoRequerida estructuraNoRequerida);
}