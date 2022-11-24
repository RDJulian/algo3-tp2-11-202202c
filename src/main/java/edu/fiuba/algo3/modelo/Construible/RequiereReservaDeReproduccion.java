package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereReservaDeReproduccion implements ConstruibleEstructura {
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
        throw new ConstruccionNoValidaException();
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

    }

    @Override
    public void visitar(PuertoEstelar estructura) {
        throw new ConstruccionNoValidaException();
    }
}