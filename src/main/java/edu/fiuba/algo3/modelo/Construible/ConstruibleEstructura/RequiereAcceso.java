package edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura;

import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;

import java.util.ArrayList;

public class RequiereAcceso extends ConstruibleEstructura {
    @Override
    public boolean visitar(Acceso acceso) {
        return true;
    }

    @Override
    public boolean visitar(Espiral espiral) {
        return false;
    }

    @Override
    public boolean visitar(Guarida guarida) {
        return false;
    }

    @Override
    public boolean visitar(PuertoEstelar puertoEstelar) {
        return false;
    }

    @Override
    public boolean visitar(ReservaDeReproduccion reservaDeReproduccion) {
        return false;
    }

    @Override
    public boolean visitar(Criadero criadero) {
        return false;
    }

    @Override
    public boolean visitar(EstructuraNoRequerida estructuraNoRequerida) {
        return false;
    }
}