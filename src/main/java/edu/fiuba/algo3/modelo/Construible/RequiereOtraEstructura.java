package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Estructura;

public interface RequiereOtraEstructura { //Esto parece muy engorroso, pero es un patron similar a los otros.
    void construible(Estructura estructura);

    void construibleConAcceso();

    void construibleConAsimilador();

    void construibleConCriadero();

    void construibleConEspiral();

    void construibleConExtractor();

    void construibleConGuarida();

    void construibleConNexoMineral();

    void construibleConPilon();

    void construibleConPuertoEstelar();

    void construibleConReservaDeReproduccion();
}
