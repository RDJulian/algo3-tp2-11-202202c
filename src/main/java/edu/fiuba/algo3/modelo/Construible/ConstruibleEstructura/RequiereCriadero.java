package edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura;

import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereCriadero implements ConstruibleEstructura {
    @Override
    public void visitar(Estructura estructura) {
        estructura.construible(this);
    }

    @Override
    public void visitar(Acceso estructura) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(Asimilador estructura) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(Criadero estructura) {

    }

    @Override
    public void visitar(Espiral estructura) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(Extractor estructura) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(Guarida estructura) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(NexoMineral estructura) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(Pilon estructura) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(ReservaDeReproduccion estructura) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(PuertoEstelar estructura) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(Nada nada) {
        throw new ConstruccionNoValidaException();
    }
}