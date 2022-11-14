package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;

public class RequiereReservaDeReproduccion implements RequiereOtraEstructura {
    @Override
    public void construible(Estructura estructura) {
        estructura.construirConOtraEstructura(this);
    }

    @Override
    public void construibleConAcceso() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construibleConAsimilador() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construibleConCriadero() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construibleConEspiral() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construibleConExtractor() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construibleConGuarida() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construibleConNexoMineral() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construibleConPilon() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construibleConPuertoEstelar() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construibleConReservaDeReproduccion() {

    }
}
