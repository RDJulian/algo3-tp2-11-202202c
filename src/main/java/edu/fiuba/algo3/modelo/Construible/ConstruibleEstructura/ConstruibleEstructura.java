package edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura;

import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;

public interface ConstruibleEstructura {
    void visitar(Estructura estructura);

    void visitar(Acceso estructura);

    void visitar(Asimilador estructura);

    void visitar(Criadero estructura);

    void visitar(Espiral estructura);

    void visitar(Extractor estructura);

    void visitar(Guarida estructura);

    void visitar(NexoMineral estructura);

    void visitar(Pilon estructura);

    void visitar(ReservaDeReproduccion estructura);

    void visitar(PuertoEstelar estructura);

    void visitar(Nada nada);
}